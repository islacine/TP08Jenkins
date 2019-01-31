pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat 'gradle build'
        bat(script: 'gradle uploadArchives', returnStatus: true, returnStdout: true)
      }
    }
    stage('mailNotification') {
      steps {
        mail(subject: 'build ', body: 'the builed ', bcc: 'fn_khettache@esi.dz', from: 'fk_mokrane@esi.dz')
      }
    }
    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            withSonarQubeEnv('sonarqube') {
              bat 'sonar-scanner'
            }

            waitForQualityGate true
          }
        }
        stage('Test Reporting') {
          steps {
            jacoco(buildOverBuild: true)
          }
        }
      }
    }
    stage('Deployment') {
      steps {
        bat 'gradle uploadArchives'
      }
    }
    stage('Slack Notification') {
      when {
        branch 'master'
      }
      steps {
        slackSend(channel: 'tp6', color: '#ffffff', message: 'tree reached slack notification')
      }
    }
  }
}
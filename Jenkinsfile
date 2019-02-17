pipeline {
  agent any
  stages {
    stage('build') {
      steps {
       }
            post {
      failure {
        mail(subject: 'build failure ', body: 'the build failed ', bcc: 'fn_khettache@esi.dz', from: 'fk_mokrane@esi.dz')
      }
      success {
        mail(subject: 'build success', body: 'the build succeeded ', bcc: 'fn_khettache@esi.dz', from: 'fk_mokrane@esi.dz')
      }
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

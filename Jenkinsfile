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
        bat(script: 'gradle uploadArchives', returnStdout: true, returnStatus: true)
      }
    }
  }
}
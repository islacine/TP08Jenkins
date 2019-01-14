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
    stage('CodeAnalysis') {
      steps {
        withSonarQubeEnv('sonarqube') {
          bat(script: 'sonar-scanner', returnStatus: true, returnStdout: true)
        }

      }
    }
  }
}

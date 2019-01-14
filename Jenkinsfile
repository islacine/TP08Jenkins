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
        mail(subject: 'build failed', body: 'the builed has failed', bcc: 'fn_khettache@esi.dz', from: 'fk_mokrane@esi.dz')
      }
    }
  }
}
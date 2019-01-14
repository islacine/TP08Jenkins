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
      environment {
      def scannerHome: tool "SonarQubeScanner"
      }
      steps {
        withSonarQubeEnv('sonarqube') {
          bat(script: 'C:\Users\Kaouthar\Desktop\SONARQUBE\sonarqube-7.3\sonarqube-7.3\bin\windows-x86-64 sonar-scanner', returnStatus: true, returnStdout: true)
        }

      }
    }
  }
}

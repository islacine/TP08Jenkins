pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat(script: 'gradle uploadArchives', returnStatus: true, returnStdout: true)
      }
    }
  }
}
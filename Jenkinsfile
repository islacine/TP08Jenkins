pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        bat 'gradle build'
        bat(script: 'gradle uploadArchives', returnStatus: true, returnStdout: true)
      }
    }
  }
}
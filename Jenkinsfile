pipeline{
  agent any
  
  stages{
    stage("build"){
          steps {
            echo 'building the application...'
          }
    }
          stage("test"){
            steps {
              echo 'testing the application...'
              withCredentials([usernamePassword(credentialsId: 'multibranchPipeline', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                echo "username: ${USER}"
                echo "password: ${PASS}"
              }
            }
          }  
          
          stage("deploy"){
            steps {
              echo 'deploying the application...'
            }
          }
  }
}

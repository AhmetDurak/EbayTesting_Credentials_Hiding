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
              withCredentials([usernamePassword(credentialsId: 'multibranchPipeline', passwordVariable: 'pass', usernameVariable: 'user')]) {
                echo "username: ${user}"
                echo "password: ${pass}"
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

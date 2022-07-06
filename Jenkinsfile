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
              withCredentials([usernamePassword(credentialsId: 'ahmetdurakId', usernameVariable: USER, passwordVariable: PWD]){
                echo "username: ${USER}"
                echo "password: ${PWD}"
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

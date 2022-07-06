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
              withCredentials([usernamePassword(credentialsId: 'ahmetdurakGlobal', passwordVariable: 'pass', usernameVariable: 'user')]) {
                echo "username: ${user}"
                echo "password: ${pwd}"
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

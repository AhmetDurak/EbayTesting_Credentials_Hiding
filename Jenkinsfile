pipeline{
  agent any
  
  stages{
    stage("build"){
      environment {
        SECRET_FILE_ID = credentials('anypointCredentials')
      }
          steps {
            echo 'building the application...'
            echo 'coping credentials to the code'
            bat "powershell copy-item ${SECRET_FILE_ID} -Destination HelloWorld/"
            bat "powershell rename-item "Secret.txt" -NewName "Credentials.properties"
          }
    }
          stage("test"){
            steps {
              echo 'testing the application...'
            }
          }  
          
          stage("deploy"){
            steps {
              echo 'deploying the application...'
            }
          }
  }
}

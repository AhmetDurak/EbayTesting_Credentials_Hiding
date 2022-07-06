def gv

pipeline{
  agent any
  
  stages{
    stage("init"){
      gy = load "script.groovy"
    }
    stage("build"){
          steps {
            echo 'building the application...'
          }
    }
          stage("test"){
            steps {
              echo 'testing the application...'
              gv.addCredentials()

            }
          }  
          
          stage("deploy"){
            steps {
              echo 'deploying the application...'
            }
          }
  }
}

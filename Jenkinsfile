pipeline {
    agent any

    environment {
        CREDENTIALS = withCredentials('')
    }

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            environment{
                SECRET_FILE_ID = credentials('CredentialsFile')
            }
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AhmetDrkTraining/qa.Fidexio.git/'

                // Put the credentials into file directory
                echo 'coping credentials to the code'
                bat "powershell copy-item ${SECRET_FILE_ID} -Destination /"

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test -q"


                bat "powershell remove-item ${SECRET_FILE_ID}"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                }
            }
        }
    }
}

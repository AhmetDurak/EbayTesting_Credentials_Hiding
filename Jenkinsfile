pipeline {
    agent any

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
                git 'https://github.com/AhmetDurak/EbayTesting_Credentials_Hiding.git'

                 //Put the credentials into file directory

                echo 'coping credentials to the code'

                // First of all we need to copy the file in to the directory
                echo 'copying the CredentialsFile'
                bat "powershell copy-item ${SECRET_FILE_ID} -Destination C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\"

                bat "powershell get-item C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\*"

                // THEN WE RUN THE CODE

                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test"

                // THEN WE REMOVE the CredentialsFile

                bat "powershell remove-item -Path C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\Credentials.properties"

                //bat "powershell get-item C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\*"

            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                }
            }
        }
    }
}

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
                SECRET_TEXT_ID = credentials('SecretKey')
                PATH = "C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"
                CONTENT = "get-content ${PATH}"
            }
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AhmetDurak/EbayTesting_Credentials_Hiding.git'

                 //Put the credentials into file directory
                //echo 'coping credentials to the code'
                //bat "powershell get-item C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\*"
                //bat "powershell remove-item -Path C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\Credentials.properties"
                //echo 'after removing the file'
                //bat "powershell get-item C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\*"

                //echo 'after copying the file'
                //bat "powershell copy-item ${SECRET_FILE_ID} -Destination C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\"
                //bat "powershell get-item C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\*"


                // replacing text with the secret text
                echo 'replacing text with the secret text'
                bat "powershell ${CONTENT}"

                bat "powershell ${CONTENT}"
                //bat "powershell (get-content ${PATH}) -replace 'ahmet','${SECRET_TEXT_ID}'| set-content ${PATH}"
                //bat "powershell get-content ${PATH}"

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                //bat "mvn clean"
                //bat "mvn test"


                //bat "powershell remove-item ${SECRET_FILE_ID}"
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

pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    stages {
        stage('Build') {
            environment{
                SECRET_TEXT_ID = credentials('SecretKey')
            }
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/AhmetDurak/EbayTesting_Credentials_Hiding.git'


                // replacing text with the secret text

                echo 'replacing text with the secret text'

                //>powershell [System.IO.File]::WriteAllText('text.file',((get-content text.file) -replace 'which text will be replace','which text will be inserted'))

                bat "powershell [System.IO.File]::WriteAllText('C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java',((get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java) -replace 'secret-key','${SECRET_TEXT_ID}'))"

                bat "powershell get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test"


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

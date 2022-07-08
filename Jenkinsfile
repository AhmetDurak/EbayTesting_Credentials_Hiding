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
               // PATH = "C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"

            }
            steps {
                echo 'Now building is starting'
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
                //String path = "C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"

                echo 'replacing text with the secret text'
                //bat "powershell get-content ${path}"

                //>powershell [System.IO.File]::WriteAllText('text.file',((get-content text.file) -replace 'is a new','MAHMUT'))
                bat "powershell [System.IO.File]::WriteAllText('C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java',((get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java) -replace 'secret-key',{SECRET_TEXT_ID}))"

                bat "powershell get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"
                //bat "powershell (get-content ${PATH}) -replace 'ahmet','${SECRET_TEXT_ID}'| set-content ${PATH}"
                //bat "powershell get-content ${PATH}"

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                //bat "powershell remove-item ${SECRET_FILE_ID}"
            }
        }
        stage('Test'){
            steps{
                echo 'Now testing is starting'
                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test"
            }
        }
    }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                         }
            }

}
//                [System.IO.File]::WriteAllText('C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java',((get-content C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java) -replace 'secret-key','${SECRET_TEXT_ID}'))"

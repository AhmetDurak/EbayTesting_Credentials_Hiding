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
                //SECRET_FILE_CONTENT = readFile 'Credentials.properties'
            }
            steps {
                echo '#########    NOW BUILDING IS STARTING   #########'
                // Get some code from a GitHub repository
                git 'https://github.com/AhmetDurak/EbayTesting_Credentials_Hiding.git'

                echo '#########    REPLACING TEXT WITH THE SECRET TEXT   #########'

                //powershell label: 'Changing secret-key', script: '''$path = "C:\\\\Windows\\\\system32\\\\config\\\\systemprofile\\\\AppData\\\\Local\\\\Jenkins\\\\.jenkins\\\\workspace\\\\FidexioCredentialDemo_master\\\\src\\\\test\\\\java\\\\com\\\\Pages\\\\PageBase.java"
                //(get-content $path) -replace \'secret-key\',\'selman\'|set-content $path'''

                powershell label: 'CHANGING THE VALUE', script: '''$path = "C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"
                (get-content $path) -replace \'secret-key\',\'selman\'|set-content $path'''

                //>powershell [System.IO.File]::WriteAllText('text.file',((get-content text.file) -replace 'is a new','MAHMUT'))
                //bat "powershell [System.IO.File]::WriteAllText('C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java',((get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java) -replace 'secret-key',{SECRET_TEXT_ID}))"
                //bat "powershell get-content C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"

            }
        }
        stage('Test'){
            steps{
                echo '#########    NOW TESTING IS STARTING   #########'
                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test"
            }
        }

        stage('Deploy'){
                    steps{
                        echo '#########    NOW DEPLOYING IS STARTING   #########'

                        echo '########   CLEANING WORKSPACE ###########'
                        cleanWs notFailBuild: true, patterns: [[pattern: 'pom.xml', type: 'EXCLUDE'], [pattern: 'src', type: 'EXCLUDE'], [pattern: 'Credentials.properties', type: 'INCLUDE']]

                    }
                }
    }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                         echo '#########    NOTIFICATION IS SENDING TO USER   #########'
                         step([$class: 'Mailer', notifyEveryUnstableBuild: false, recipients: 'volkaff51@gmail.com', sendToIndividuals: false])
                         }
            }

}
//                [System.IO.File]::WriteAllText('C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java',((get-content C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java) -replace 'secret-key','${SECRET_TEXT_ID}'))"

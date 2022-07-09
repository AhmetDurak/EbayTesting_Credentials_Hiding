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
                //SECRET_FILE_CONTENT = readFile 'Credentials.properties'
            }
            steps {
                echo '##################################################'
                echo '#########     NOW BUILDING IS STARTING   #########'
                echo '##################################################'

                // Get some code from a GitHub repository
                git 'https://github.com/AhmetDurak/EbayTesting_Credentials_Hiding.git'

                echo '############################################################'
                echo '#########    REPLACING SECRET-KEY WITH REAL ONE    #########'
                echo '############################################################'

                powershell label: 'CHANGING THE VALUE', script: '''$path = "C:\\Windows\\system32\\config\\systemprofile\\AppData\\Local\\Jenkins\\.jenkins\\workspace\\FidexioCredentialDemo_master\\src\\test\\java\\com\\Pages\\PageBase.java"
                (get-content $path) -replace \'secret-key\',\'selman\'|set-content $path'''
            }
        }
        stage('Test'){
            steps{
                echo '##################################################'
                echo '#########     NOW TESTING IS STARTING    #########'
                echo '##################################################'

                // To run Maven on a Windows agent, use
                bat "mvn clean"
                bat "mvn test"
            }
        }
        stage('Deploy'){
                    steps{
                        echo '##################################################'
                        echo '#########    NOW DEPLOYING IS STARTING   #########'
                        echo '##################################################'

                        echo '##################################################'
                        echo '########        CLEANING WORKSPACE     ###########'
                        echo '##################################################'

                        cleanWs notFailBuild: true, patterns: [[pattern: 'pom.xml', type: 'EXCLUDE'], [pattern: 'src', type: 'EXCLUDE'], [pattern: 'Credentials.properties', type: 'INCLUDE']]

                    }
                }
    }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                always {
                    cucumber buildStatus: 'null', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
                         echo '##################################################'
                         echo '#########   REPORT IS SENDING TO EMAIL   #########'
                         echo '##################################################'
                         step([$class: 'Mailer', notifyEveryUnstableBuild: false, recipients: 'volkaff51@gmail.com', sendToIndividuals: false])


                         echo '#########################################################'
                         echo '#########    NOTIFICATION IS SENDING TO EMAIL   #########'
                         echo '#########################################################'

                         mail bcc: '', body: 'This is a notification message', cc: '', from: '', replyTo: '', subject: 'Test-Report-Demo', to: 'durakahmet49@gmail.com'
                         }
            }

}
//                [System.IO.File]::WriteAllText('C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java',((get-content C:\Users\volka\IdeaProjects\EbayTesting_Credentials_Hiding\src\test\java\com\Pages\PageBase.java) -replace 'secret-key','${SECRET_TEXT_ID}'))"

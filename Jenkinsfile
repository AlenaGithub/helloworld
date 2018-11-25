pipeline {
    agent any

    environment {
        DISABLE_AUTH = 'true'
        DB_ENGINE    = 'sqlite'
    }

    parameter {
        choice(name: 'door_choice',
            choices: 'one\ntwo\nthree\nfour',
            description: 'What door do you choose?'
        )
        booleanParam(name: 'CAN_DANCE',
            defaultValue: true,
            description: 'Checkbox parameter'
        )
        string(name: 'myString',
        defaultValue: 'Dance!',
        description: 'Do the funky chicken!'
        )
    }

    stages {
        stage('Build') {
            steps {
                sh 'echo "Hello World"'
                sh 'printenv'
                sh '''
                    echo "Multiline shell steps works too"
                    ls -lah
                '''

                sh './gradlew build'
            }
        }

        stage('Test') {
            steps {
                sh './gradlew check'
                //sh 'echo "Fail!"; exit 1'
                input "Does the staging environment look ok?"
            }
        }
//        stage('Sanity check') {
//            steps {
//                input "Does the staging environment look ok?"
//            }
//        }
    }
//The ‘properties’ section has been renamed as of version 0.8. Use ‘options’ instead. @ line 38, column 1.

//options([
//  parameters([
//    string(name: 'submodule', defaultValue: 'spring-music'),
//    string(name: 'submodule_branch', defaultValue: 'develop')
//  ])
//])


    post {
        always {
            echo 'This will always run'
//            archiveArtifacts artifacts: 'build/libs/**/*.jar', fingerprint: true
//            junit 'build/reports/**/*.xml'
            deleteDir() /* clean up our workspace */
        }
        success {
            echo 'This will run only if successful'
            slackSend channel: '#ops-room',
              color: 'good',
              message: "The pipeline ${currentBuild.fullDisplayName} completed successfully."
        }
        failure {
            echo 'This will run only if failed'
            mail to: 'lihua.li@cgi.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
        unstable {
            echo 'This will run only if the run was marked as unstable'
        }
        changed {
            echo 'This will run only if the state of the Pipeline has changed'
            echo 'For example, if the Pipeline was previously failing but is now successful'
        }
    }
}


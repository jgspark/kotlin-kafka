rootProject.name = "kotlin-kafka"

include(
    ":workspace:legacy",
    ":workspace:kafka-stream-example",
    ":workspace:kafka-stream-push-sample"
)

pluginManagement {
    val kotlinVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val asciidoctorConvertVersion: String by settings

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "plugin.allopen" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.allopen" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.kapt" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.jvm" -> useVersion(kotlinVersion)
                "org.jetbrains.kotlin.plugin.spring" -> useVersion(kotlinVersion)
                "org.springframework.boot" -> useVersion(springBootVersion)
                "io.spring.dependency-management" -> useVersion(springDependencyManagementVersion)
                "org.asciidoctor.jvm.convert" -> useVersion(asciidoctorConvertVersion)
            }
        }
    }
}

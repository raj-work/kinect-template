package com.kinect.messaging.template.model

import com.azure.spring.data.cosmos.core.mapping.Container
import com.azure.spring.data.cosmos.core.mapping.PartitionKey
import org.springframework.data.annotation.Id

@Container(containerName = "templates")
data class Template(
    @Id
    val id: String,
    @PartitionKey
    val name: String,
    val type: TemplateType = TemplateType.CONTROL,
    val language: TemplateLanguage = TemplateLanguage.EN,
    val content: String
)

enum class TemplateLanguage {
    EN, ES
}

enum class TemplateType {
    CONTROL, TREATMENT
}

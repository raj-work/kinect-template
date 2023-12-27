package com.kinect.messaging.template.service

import com.kinect.messaging.template.model.Template
import com.kinect.messaging.template.repository.TemplateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class TemplateService{

    @Autowired
    lateinit var templateRepository: TemplateRepository

    fun findTemplateById(id: String): Mono<Template> = templateRepository.findById(id)

    fun saveTemplate(template: Template): Mono<Template> = templateRepository.save(template)

    fun findTemplates(): Flux<Template> = templateRepository.findAll()


}
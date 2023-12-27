package com.kinect.messaging.template.controller

import com.kinect.messaging.template.model.Template
import com.kinect.messaging.template.service.TemplateService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController()
@RequestMapping("/kinect/messaging/template")
class TemplateController {

    @Autowired
    lateinit var templateService: TemplateService

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createTemplate(@RequestBody template: Template): Mono<Template>{
        val updatedTemplate = templateService.saveTemplate(template)
        return updatedTemplate
    }

    @GetMapping("/{id}")
    fun getTemplate(@PathVariable id: String): Mono<Template> = templateService.findTemplateById(id)

    @GetMapping("/")
    fun getAllTemplates(): Flux<Template> = templateService.findTemplates()

}
package com.kinect.messaging.template.repository

import com.azure.spring.data.cosmos.repository.CosmosRepository
import com.azure.spring.data.cosmos.repository.ReactiveCosmosRepository
import com.kinect.messaging.template.model.Template
import org.springframework.stereotype.Repository

@Repository
interface TemplateRepository : ReactiveCosmosRepository<Template, String>
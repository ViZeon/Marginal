package com.complexace.marginal.repository

import com.complexace.marginal.core.model.*
import com.complexace.marginal.core.interfaces.PlatformConnector

class MarginalRepository(private val connector: PlatformConnector) {

    suspend fun getWork(url: String): Result<Work> =
        connector.getWork(url)

    suspend fun getChapter(url: String): Result<Chapter> =
        connector.getChapter(url)

    suspend fun getComments(chapterUrl: String): Result<List<Comment>> =
        connector.getComments(chapterUrl)

    suspend fun postComment(chapterUrl: String, text: String): Result<Unit> =
        connector.postComment(chapterUrl, text)

    suspend fun search(query: String, filters: Map<String, String>): Result<List<WorkSummary>> =
        connector.search(query, filters)
}
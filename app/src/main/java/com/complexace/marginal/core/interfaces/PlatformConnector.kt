package com.complexace.marginal.core.interfaces

import com.complexace.marginal.core.model.Chapter
import com.complexace.marginal.core.model.Comment
import com.complexace.marginal.core.model.Work
import com.complexace.marginal.core.model.WorkSummary

interface PlatformConnector {

    val displayName: String

    // Auth
    suspend fun login(username: String, password: String): Result<Unit>
    suspend fun logout(): Result<Unit>
    suspend fun isLoggedIn(): Boolean

    // Works
    suspend fun getWork(url: String): Result<Work>
    suspend fun getChapter(url: String): Result<Chapter>
    suspend fun search(query: String, filters: Map<String, String>): Result<List<WorkSummary>>

    // Comments
    suspend fun getComments(chapterUrl: String): Result<List<Comment>>
    suspend fun postComment(chapterUrl: String, text: String): Result<Unit>
}
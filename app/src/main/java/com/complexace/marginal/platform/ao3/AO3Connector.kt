package com.complexace.marginal.platform.ao3

import com.complexace.marginal.core.interfaces.PlatformConnector
import com.complexace.marginal.core.model.Chapter
import com.complexace.marginal.core.model.Comment
import com.complexace.marginal.core.model.Work
import com.complexace.marginal.core.model.WorkSummary

class AO3Connector : PlatformConnector {

    override val displayName = "Archive of Our Own"

    override suspend fun login(username: String, password: String): Result<Unit> {
        TODO("WebView login — Phase 2")
    }

    override suspend fun logout(): Result<Unit> {
        TODO("WebView logout — Phase 2")
    }

    override suspend fun isLoggedIn(): Boolean {
        TODO("Check session cookie — Phase 2")
    }

    override suspend fun getWork(url: String): Result<Work> {
        TODO("JS extraction — Phase 2")
    }

    override suspend fun getChapter(url: String): Result<Chapter> {
        TODO("JS extraction — Phase 2")
    }

    override suspend fun search(query: String, filters: Map<String, String>): Result<List<WorkSummary>> {
        TODO("JS extraction — Phase 2")
    }

    override suspend fun getComments(chapterUrl: String): Result<List<Comment>> {
        TODO("JS extraction — Phase 2")
    }

    override suspend fun postComment(chapterUrl: String, text: String): Result<Unit> {
        TODO("WebView form submit — Phase 2")
    }
}
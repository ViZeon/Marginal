package com.complexace.marginal.core

import com.complexace.marginal.core.interfaces.PlatformConnector
import com.complexace.marginal.core.model.*

class MockConnector : PlatformConnector {

    override val displayName = "Mock"

    override suspend fun isLoggedIn() = true
    override suspend fun login(username: String, password: String) = Result.success(Unit)
    override suspend fun logout() = Result.success(Unit)

    override suspend fun getWork(url: String): Result<Work> {
        return Result.success(
            Work(
                id = "mock_work_1",
                platform = Platform("mock", "Mock"),
                title = "Letters Never Sent",
                author = "winterlight",
                summary = "A story about the letters we write but never send, and the silence that grows in their place.",
                metadata = WorkMetadata(
                    tags = listOf("Angst", "Slow Burn", "Found Family", "Hurt/Comfort"),
                    fandom = listOf("Original Work"),
                    relationships = listOf("Mira & Daniel"),
                    characters = listOf("Mira", "Daniel", "Sara"),
                    wordCount = 87400,
                    chapterCount = 12,
                    totalChapters = 34,
                    kudos = 4821,
                    bookmarks = 903,
                    hits = 62000,
                    isComplete = false,
                    language = "English",
                    rating = "Teen And Up"
                ),
                chapterIds = listOf("mock_ch_1", "mock_ch_2", "mock_ch_3")
            )
        )
    }

    override suspend fun getChapter(url: String): Result<Chapter> {
        return Result.success(
            Chapter(
                id = "mock_ch_1",
                workId = "mock_work_1",
                index = 12,
                title = "The Weight of Silence",
                authorNote = "Thank you for all the comments on the last chapter. This one hurt to write.",
                paragraphs = listOf(
                    Paragraph(0, "The letter had been sitting on the kitchen table for three days. Mira circled it each morning with her coffee, close enough to see the handwriting — his handwriting — but never close enough to touch."),
                    Paragraph(1, "\"You could just open it,\" her sister had said, which was the most useless thing anyone had ever said to her."),
                    Paragraph(2, "On the fourth morning, she sat down. She put both hands flat on the table, palms down, fingers spread. She counted her breaths the way the therapist had taught her. One. The envelope. Two. The return address she already knew. Three."),
                    Paragraph(3, "She stood up and made more coffee."),
                    Paragraph(4, "The thing about waiting, she had come to understand, was that it was not really about the thing being waited for. It was about the particular shape of the silence that surrounded it — the way everything else arranged itself around the absence, taking on its edges."),
                    Paragraph(5, "Daniel had always filled silence badly. He talked into it, plastered it over with noise, music, plans. She had found it exhausting and then endearing and then, toward the end, exhausting again."),
                    Paragraph(6, "The letter did not move. She had not expected it to.")
                )
            )
        )
    }

    override suspend fun search(query: String, filters: Map<String, String>): Result<List<WorkSummary>> {
        return Result.success(emptyList())
    }

    override suspend fun getComments(chapterUrl: String): Result<List<Comment>> {
        return Result.success(
            listOf(
                Comment(
                    id = "mock_c1",
                    workId = "mock_work_1",
                    chapterId = "mock_ch_1",
                    paragraphIndex = 3,
                    author = "readinginthevoid",
                    text = "[p3] this line destroyed me",
                    timestamp = "2024-11-01"
                ),
                Comment(
                    id = "mock_c2",
                    workId = "mock_work_1",
                    chapterId = "mock_ch_1",
                    paragraphIndex = null,
                    author = "quietpages",
                    text = "The therapist detail is such good character work.",
                    timestamp = "2024-11-02"
                )
            )
        )
    }

    override suspend fun postComment(chapterUrl: String, text: String) = Result.success(Unit)
}
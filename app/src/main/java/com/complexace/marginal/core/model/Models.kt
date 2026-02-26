package com.complexace.marginal.core.model

// Which platform a work comes from
data class Platform(
    val id: String,
    val displayName: String
)

// A single paragraph of text within a chapter
data class Paragraph(
    val index: Int,          // position in chapter, used for paragraph comments
    val text: String
)

// A full chapter's content
data class Chapter(
    val id: String,          // platform-specific ID
    val workId: String,
    val index: Int,          // chapter number (1-based)
    val title: String,
    val paragraphs: List<Paragraph>,
    val authorNote: String? = null   // pre/post chapter notes (common on AO3)
)

// Metadata about a work — shown on work page, search results
data class WorkMetadata(
    val tags: List<String>,
    val fandom: List<String>,
    val relationships: List<String>,
    val characters: List<String>,
    val wordCount: Int,
    val chapterCount: Int,          // published chapters
    val totalChapters: Int?,        // null = unknown/ongoing
    val kudos: Int,
    val bookmarks: Int,
    val hits: Int,
    val isComplete: Boolean,
    val language: String,
    val rating: String              // e.g. "Mature", "Teen And Up"
)

// A work (fic)
data class Work(
    val id: String,
    val platform: Platform,
    val title: String,
    val author: String,
    val summary: String,
    val metadata: WorkMetadata,
    val chapterIds: List<String>    // ordered list, used to navigate prev/next
)

// A comment — paragraphIndex null = chapter-level, non-null = paragraph-level
data class Comment(
    val id: String,
    val workId: String,
    val chapterId: String,
    val paragraphIndex: Int?,       // null = chapter comment
    val author: String,
    val text: String,               // stored/posted with [pN] prefix if paragraphIndex != null
    val timestamp: String,
    val parentId: String? = null    // null = top-level, non-null = reply
)

// Where the user is in a work — persisted locally
data class ReadingPosition(
    val workId: String,
    val chapterId: String,
    val paragraphIndex: Int,        // last visible paragraph
    val scrollOffset: Int,          // pixel offset within that paragraph
    val timestamp: Long             // last updated, epoch ms
)

// Lightweight work summary for search results / library lists
data class WorkSummary(
    val id: String,
    val platform: Platform,
    val title: String,
    val author: String,
    val metadata: WorkMetadata
)

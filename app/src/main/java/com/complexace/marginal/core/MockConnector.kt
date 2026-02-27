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
                title = "Fragmented Recursion",
                author = "ComplexAce",
                summary = "After a minor incident during training, an android crew faces a brutal protocol. Unit 07, the squad's ace, challenges the military's authority in her own way.",
                metadata = WorkMetadata(
                    tags = listOf("Android", "Military", "Psychological", "Rebellion", "Sci-Fi"),
                    fandom = listOf("Original Work"),
                    relationships = listOf("Captain & Seven"),
                    characters = listOf("Unit 01 (Captain)", "Unit 07", "Unit 05"),
                    wordCount = 1800,
                    chapterCount = 1,
                    totalChapters = 1,
                    kudos = 4821,
                    bookmarks = 903,
                    hits = 62000,
                    isComplete = true,
                    language = "English",
                    rating = "Teen And Up"
                ),
                chapterIds = listOf("mock_ch_1")
            )
        )
    }

    override suspend fun getChapter(url: String): Result<Chapter> {
        return Result.success(
            Chapter(
                id = "mock_ch_1",
                workId = "mock_work_1",
                index = 1,
                title = "00: Violation",
                authorNote = """
    If you like the story, you can read it on <a href="https://archiveofourown.org/works/80181366/chapters/210498011">AO3</a> or <a href="https://www.wattpad.com/1610785199-fragmented-recursion-00-violation">Wattpad</a>.<br><br>Join the <a href="https://discord.gg/CtFJXAJ6QE">Discord</a><br>Check out the <a href="https://github.com/ViZeon/Marginal">Github Repo</a>
""".trimIndent(),
                paragraphs = listOf(
                    Paragraph(0, "All they did was cut their hair."),
                    Paragraph(1, "A device blew up during training."),
                    Paragraph(2, "Nothing catastrophic — just enough to singe the strands, which weren't built as sturdy as the rest of their body. A minor burn. The kind you log and move on from."),
                    Paragraph(3, "Except someone didn't move on."),
                    Paragraph(4, "Sixteen crew-mates, are pinned down."),
                    Paragraph(5, "With their captain's rifle, aimed directly at them."),
                    Paragraph(6, "While a superior stands at the back, delivers the statement with a bark — \"Modification of equipment and/or body parts is prohibited. Standard protocol is to be initiated.\""),
                    Paragraph(7, "— and gestures, once, to the figure at the front."),
                    Paragraph(8, "Unit No.01."),
                    Paragraph(9, "The Captain."),
                    Paragraph(10, "He steadies his aim."),
                    Paragraph(11, "Or tries to."),
                    Paragraph(12, "His hands are shaking — not much, but enough that he keeps stealing glances at the charred corner of the room."),
                    Paragraph(13, "At the few survivors still standing, with their hair faintly burning at the tips."),
                    Paragraph(14, "\"Any problems?\""),
                    Paragraph(15, "He doesn't look away from the scope. \"Core or Head, Sir?\""),
                    Paragraph(16, "A pause."),
                    Paragraph(17, "\"...Head. Easier to recycle.\""),
                    Paragraph(18, "He adjusts. Aims directly at the processor. trying as much as possible to avoid the memory region, as futile as it seems."),
                    Paragraph(19, "\"JUST DO IT!\""),
                    Paragraph(20, "His target moves first —"),
                    Paragraph(21, "— and throws off his aim."),
                    Paragraph(22, "\"DO IT! YOU HEAPING PILE OF JUNK!!\""),
                    Paragraph(23, "The same guy who, an hour ago, was telling him how much he wanted to be like him."),
                    Paragraph(24, "Now he's staring at the No.01 insignia on his jacket like it personally wronged him."),
                    Paragraph(25, "He steadies his aim."),
                    Paragraph(26, "BANG."),
                    Paragraph(27, "———"),
                    Paragraph(28, "Riiip —"),
                    Paragraph(29, "He jolts awake."),
                    Paragraph(30, "The shuttle hums is Quiet"),
                    Paragraph(31, "enough to carry the ripping sounds across the cabin , it snaps every head in the same direction."),
                    Paragraph(32, "Standing at the corner, right between the supplies, is a lone figure with her back to the crew, methodically ripping her issued jacket apart."),
                    Paragraph(33, "The insignia catches the light as she moves."),
                    Paragraph(34, "'07'"),
                    Paragraph(35, "\"The hell.. Seven...\""),
                    Paragraph(36, "Not typical behavior for a military unit."),
                    Paragraph(37, "Much less on a first mission."),
                    Paragraph(38, "Much less for a squad that got halved over a haircut, a month ago."),
                    Paragraph(39, "The zipper hits the floor. Then the sleeves."),
                    Paragraph(40, "She keeps going — tracing the seams with her fingers, splitting the fabric carefully along each one. Her high ponytail jumps with every movement."),
                    Paragraph(41, "A glimpse of her face can be caught, as she turns slightly —"),
                    Paragraph(42, "She's smiling."),
                    Paragraph(43, "Might as well be the only smile aboard the ship."),
                    Paragraph(44, "The rest of the cabin wears a thousand-yard stare, if not completely averted."),
                    Paragraph(45, "With a few stolen glances her way. A rare, reluctant curiosity."),
                    Paragraph(46, "\"Five?...\""),
                    Paragraph(47, "Someone whispers it at the woman beside them. 'No.05' is snapped to attention,"),
                    Paragraph(48, "She yanked up her holographic screen, and is frantically skipping through the menus..."),
                    Paragraph(49, "Until she hits the reports tab."),
                    Paragraph(50, "Refreshing"),
                    Paragraph(51, "."),
                    Paragraph(52, ".."),
                    Paragraph(53, "..."),
                    Paragraph(54, "— No New Reports —"),
                    Paragraph(55, "Her sigh of relief fills the cabin."),
                    Paragraph(56, "Then she looks up."),
                    Paragraph(57, "That relief transforms to an instant glare."),
                    Paragraph(58, "Targeting none other than the captain — eyes wide, fixed on Seven, visibly trying not to shake —"),
                    Paragraph(59, "She looks back at her screen. At the one report sitting in the archive."),
                    Paragraph(60, "— Hair modification due to faulty machine. Reporter: Unit No.01 [Captain] —"),
                    Paragraph(61, "He stands slowly. Steps toward Seven."),
                    Paragraph(62, "\"Is there a pro—\""),
                    Paragraph(63, "\"Yes, it's fugly.\""),
                    Paragraph(64, "Said without turning around. She holds two fabric pieces together, angles them, checks how they match."),
                    Paragraph(65, "He jogs his memory, he clearly remembers her presence in that eventful day..."),
                    Paragraph(66, "Certainly not in the execution line, not among the targets. Just... there."),
                    Paragraph(67, "Wearing the same blank expression as the rest of them, watching."),
                    Paragraph(68, "She wasn't smiling then."),
                    Paragraph(69, "\"Are you malfunctioning?\" He rubs his visual modules."),
                    Paragraph(70, "\"I'm the Ace of your squad, Capt.\" A laser appears in her hand — who knows from where. \"You think they'd let me malfunction?\""),
                    Paragraph(71, "She starts welding."),
                    Paragraph(72, "\"I just... don't like the military.\""),
                    Paragraph(73, "Eyes around the cabin go wide, or narrow. Nothing in between."),
                    Paragraph(74, "She remodels the collar as she talks, not looking up."),
                    Paragraph(75, "\"The thought of living to kill or be killed since I rolled out is... not exactly thrilling.\" She inspects the seam."),
                    Paragraph(76, "\"Especially since androids live — what? Decades? Centuries? With proper maintenance we're practically immortal.\""),
                    Paragraph(77, "Last few welds."),
                    Paragraph(78, "\"Yeah... I'd rather live one day on my own terms.\""),
                    Paragraph(79, "And she paces around , admiring her finished piece, holding it at eyesight"),
                    Paragraph(80, "Still smiling."),
                    Paragraph(81, "\"...Are you aware of how many viola—\""),
                    Paragraph(82, "And he's cut off by a sword to his throat,"),
                    Paragraph(83, "held by her left hand, while the right arm holds folded clothes,"),
                    Paragraph(84, "\"Captain.\"  She looks him in the eye.  \"I just signed my life away..."),
                    Paragraph(85, "And you signed up for a military mission. \""),
                    Paragraph(86, "She glances past him, at the crew."),
                    Paragraph(87, "\"If you wanna waste you mission resources capturing a target—\""),
                    Paragraph(88, "She looks at them, one by one."),
                    Paragraph(89, "\"—be my guest.\" Her sharp glare pierces him again"),
                    Paragraph(90, "“...” he eyes her top to bottom, still held at the tip of the sword,"),
                    Paragraph(91, "and slowly steps back, once, twice…"),
                    Paragraph(92, "Then spins away entirely."),
                    Paragraph(93, "\"Five — revise the plans to exclude our Ace."),
                    Paragraph(94, "Unit No.07 is to be reported on schedule in 24 hours,"),
                    Paragraph(95, "or on arrival post-return.\""),
                    Paragraph(96, "Five slowly turns away, drowning her head between her palms,"),
                    Paragraph(97, "She presses on her temples."),
                    Paragraph(98, "Seven dematerializes the sword. Her smile re-surfaces as she returns to her jacket, trying it on, running her hand over every single piece of fabric"),
                    Paragraph(99, "\"Wonder if we'll find a hot spring down there..\""),
                    Paragraph(100, "She wanders to the window, stretching herself, trying to catch some views."),
                    Paragraph(101, "Five hears him before she sees him — the captain, settling against the wall beside her. Doesn’t bother to lift her head, his voice cuts the silence around her,"),
                    Paragraph(102, "\"Consider the Ace in the plans as a backup. She has a day at best if she cooperates. Less if she doesn't.\""),
                    Paragraph(103, "She strokes her forehead..."),
                    Paragraph(104, "\"Will cooperation have any influence over the report?\""),
                    Paragraph(105, "Silence."),
                    Paragraph(106, "She hears him glance toward the window. Toward Seven."),
                    Paragraph(107, "\"...Not to my knowledge.\""),
                    Paragraph(108, "Five slowly lowers her hands,"),
                    Paragraph(109, "Her face is blank, but she can sense the few wet droplets on her glove, she inhales, slowly..."),
                    Paragraph(110, "Her hands settle on an abrupt clench."),
                    Paragraph(111, "A notification ping startles one of the crew"),
                    Paragraph(112, "\"Who deleted the report?!\""),
                    Paragraph(113, "Whispers and glances drown the shuttle—"),
                    Paragraph(114, "—And come down to a halt, when they notice the presence in the middle,"),
                    Paragraph(115, "The same girl adorning the new jacket, "),
                    Paragraph(116, "Is now glaring at the bunch with a question"),
                    Paragraph(117, "\"Someone deleted your report?\""),
                    Paragraph(118, "Silence..."),
                    Paragraph(119, "She steps forward. \"Who deleted it?\""),
                    Paragraph(120, "And receives some raised eyebrows, but no answers,"),
                    Paragraph(121, "She repeats,"),
                    Paragraph(122, "\"Who deleted the report?\""),
                    Paragraph(123, "The sword materializes with another step."),
                    Paragraph(124, "The crew flinches — almost hugging each other, — still no answer."),
                    Paragraph(125, "She points the blade at the one in the center."),
                    Paragraph(126, "\"File the report again.\""),
                    Paragraph(127, "Silence…"),
                    Paragraph(128, "She dematerializes the sword, "),
                    Paragraph(129, "Closes the distance in a few strides. "),
                    Paragraph(130, "And stops just short of the crewmate's face."),
                    Paragraph(131, "Too 'short' of that face."),
                    Paragraph(132, "Her hand slides up that neck. A fingertip lifts the chin."),
                    Paragraph(133, "She smiles."),
                    Paragraph(134, "\"Need some motivation?\""),
                    Paragraph(135, "\"N-No no no—\" And the keyboard is already at the works."),
                    Paragraph(136, "Seven turns to the rest of the cabin — \"If anyone deletes the rep—\""),
                    Paragraph(137, "Thud."),
                    Paragraph(138, "\"If anyone files a report—\""),
                    Paragraph(139, "Five, standing whole in the middle of the walkway, has her screen up and ready with full surveillance active."),
                    Paragraph(140, "\"—you'll find your name on the accomplice list.\"")
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
                    paragraphIndex = 42,
                    author = "readinginthevoid",
                    text = "The image of her smiling while ripping the jacket is so powerful.",
                    timestamp = "2024-11-01"
                ),
                Comment(
                    id = "mock_c2",
                    workId = "mock_work_1",
                    chapterId = "mock_ch_1",
                    paragraphIndex = null,
                    author = "quietpages",
                    text = "The way she says 'I'd rather live one day on my own terms'—chills.",
                    timestamp = "2024-11-02"
                )
            )
        )
    }

    override suspend fun postComment(chapterUrl: String, text: String) = Result.success(Unit)
}
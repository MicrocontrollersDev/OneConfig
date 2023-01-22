@file:Suppress("DSL_SCOPE_VIOLATION")
/**
 * WHATEVER HAPPENS HERE MUST ALSO BE APPLIED IN lwjgl-repacked
 */
plugins {
    alias(libs.plugins.kotlin) apply false
    id(pgtLibs.plugins.pgtRoot.get().pluginId)
}

preprocess {
    val forge10809 = createNode("1.8.9-forge", 10809, "srg")
    val fabric10809 = createNode("1.8.9-fabric", 10809, "yarn")
    val forge11202 = createNode("1.12.2-forge", 11202, "srg")
    val fabric11202 = createNode("1.12.2-fabric", 11202, "yarn")
    val forge11605 = createNode("1.16.5-forge", 11605, "srg")
    val fabric11605 = createNode("1.16.5-fabric", 11605, "yarn")
    val fabric11701 = createNode("1.17.1-fabric", 11701, "yarn")
    val forge11701 = createNode("1.17.1-forge", 11701, "srg")

    forge11701.link(fabric11701)
    fabric11701.link(fabric11605, file("1.17.1-1.16.5.txt"))
    fabric11605.link(forge11605, file("fabric-forge-modern.txt"))
    forge11605.link(forge11202, file("1.16.5-1.12.2.txt"))
    fabric11202.link(fabric10809)
    forge11202.link(forge10809, file("1.12.2-1.8.9.txt"))
    fabric10809.link(forge10809, file("fabric-forge-legacy.txt"))
}
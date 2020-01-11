package com.aminghadersohi.plugin.core

abstract class PluginList<Plugin, PluginContext>(
    val defaultContext: PluginContext
) : PluginSelector<Plugin, PluginContext> {
    override fun plugin(context: PluginContext): Plugin? =
        plugins(context).firstOrNull()

    override fun plugin(index: Int, context: PluginContext): Plugin? {
        val builder = builders().getOrNull(index)
        if (builder!= null && builder.applicable(context)) {
            return builder.build(context)
        }
        return null
    }

    override fun plugins(context: PluginContext): List<Plugin> =
        builders()
            .filter { it.applicable(context) }
            .map { it.build(context) }

    abstract fun builders(): List<PluginBuilder<Plugin, PluginContext>>
}
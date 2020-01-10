package com.aminghadersohi.plugin.core

abstract class PluginList<Plugin, PluginContext>(
    val defaultContext: PluginContext
) : PluginSelector<Plugin, PluginContext> {
    override fun plugin(context: PluginContext): Plugin? = builders().first().build(context)

    override fun plugin(index: Int, context: PluginContext): Plugin? = builders().get(index).build(context)

    override fun plugins(context: PluginContext): List<Plugin>? = builders().map { it.build(context) }

    abstract fun builders(): List<PluginBuilder<Plugin, PluginContext>>
}
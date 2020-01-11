package com.aminghadersohi.plugin.core

abstract class PluginMap<Key, Plugin, PluginContext>(
    defaultContext: PluginContext
) : PluginList<Plugin, PluginContext>(defaultContext = defaultContext),
    PluginMapSelector<Key, Plugin, PluginContext> {
    override fun plugin(key: Key, context: PluginContext): Plugin? {
        return buildersMap()[key]!!.build(context)
    }

    override fun plugin(context: PluginContext): Plugin? {
        return buildersMap().toList().first().second.build(context)
    }

    override fun plugin(index: Int, context: PluginContext): Plugin? {
        return buildersMap().toList().first().second.build(context)
    }

    override fun plugins(context: PluginContext): List<Plugin> {
        return buildersMap().toList().map { it.second.build(context) }
    }

    abstract fun buildersMap(): Map<Key, PluginBuilder<Plugin, PluginContext>>
}
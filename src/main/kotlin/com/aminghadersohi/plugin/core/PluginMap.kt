package com.aminghadersohi.plugin.core

abstract class PluginMap<Key, Plugin, PluginContext>(
    defaultContext: PluginContext
) : PluginList<Plugin, PluginContext>(defaultContext = defaultContext),
    PluginMapSelector<Key, Plugin, PluginContext> {
    override fun plugin(key: Key, context: PluginContext): Plugin? {
        return buildersMap()[key]!!.build(context)
    }

    override fun builders(): List<PluginBuilder<Plugin, PluginContext>> = buildersMap().values.toList()

    abstract fun buildersMap(): Map<Key, PluginBuilder<Plugin, PluginContext>>
}
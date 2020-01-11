package com.aminghadersohi.plugin.core

abstract class PluginMap<Key, Plugin, PluginContext>(
    defaultContext: PluginContext
) : PluginList<Plugin, PluginContext>(defaultContext = defaultContext),
    PluginMapSelector<Key, Plugin, PluginContext> {
    override fun plugin(key: Key, context: PluginContext): Plugin? {
        val builder = buildersMap()[key]
        if (builder != null && builder.applicable(context)) {
            return builder.build(context)
        }
        return null
    }

    override fun builders(): List<PluginBuilder<Plugin, PluginContext>> = buildersMap().values.toList()

    abstract fun buildersMap(): Map<Key, PluginBuilder<Plugin, PluginContext>>
}
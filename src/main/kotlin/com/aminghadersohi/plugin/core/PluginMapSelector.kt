package com.aminghadersohi.plugin.core

interface PluginMapSelector<Key, Plugin, PluginContext> : PluginSelector<Plugin, PluginContext> {
    fun plugin(key: Key, context: PluginContext): Plugin?
}
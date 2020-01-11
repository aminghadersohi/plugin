package com.aminghadersohi.plugin.core

interface PluginSelector<Plugin, PluginContext> {
    fun plugin(context: PluginContext): Plugin?
    fun plugin(index: Int, context: PluginContext): Plugin?
    fun plugins(context: PluginContext): List<Plugin>
}
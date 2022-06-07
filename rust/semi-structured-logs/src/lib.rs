// This stub file contains items that aren't used yet; feel free to remove this module attribute
// to enable stricter warnings.
#![allow(unused)]

/// various log levels
#[derive(Clone, PartialEq, Debug)]
pub enum LogLevel {
    Info,
    Warning,
    Error,
    Debug
}
/// primary function for emitting logs
pub fn log(level: LogLevel, message: &str) -> String {
    return match level {
        LogLevel::Info => format!("[{}]: {}", "INFO", message),
        LogLevel::Warning => format!("[{}]: {}", "WARNING", message),
        LogLevel::Error => format!("[{}]: {}", "ERROR", message),
        LogLevel::Debug => format!("[{}]: {}", "DEBUG", message),
    };
}
pub fn info(message: &str) -> String {
    return log(LogLevel::Info, message);
}
pub fn warn(message: &str) -> String {
    return log(LogLevel::Warning, message);
}
pub fn error(message: &str) -> String {
    return log(LogLevel::Error, message);
}

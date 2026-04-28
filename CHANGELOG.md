# BlockTuner pitchsmith

BlockTuner pitchsmith is a Fabric fork of the original BlockTuner, adjusted for builders who spend more time repeatedly tuning note blocks.

This branch keeps the familiar tuning workflow, but focuses on a setup that is more practical for heavy `tune` usage: cleaner input handling, configurable pitch-copy behavior, and a more maintainable configuration and build setup.

## Highlights

- Renamed from `BlockTuner Classic` to `BlockTuner pitchsmith`
- Better suited for builders who repeatedly tune note blocks during large builds
- Added a YACL-powered config screen with Mod Menu integration
- Added `require-ctrl-to-copy-pitch` so pitch-copy behavior can be configured explicitly
- Reworked input handling around GUI access, note display, and related interactions
- Prevented the tuning GUI from opening when placing tagged note blocks
- Updated build, Stonecutter, Gradle, and Loom setup for ongoing maintenance

## RS256 Commit Summary

This release mainly follows the recent `RS256` work on the fork:

- `491645a` clarified that this fork predates the upstream GPL relicensing and has not synced later upstream GPL commits
- `720ba27` renamed the project from `classic` to `pitchsmith`
- `a890d51` added `Modrinth.md` and refreshed repository-facing documentation
- `424afb9` rewrote configuration text in English and Japanese
- `c7d8b29` introduced `require-ctrl-to-copy-pitch`
- `82b230c` added YACL-powered configuration and Mod Menu integration
- `386f5cd` reworked `InputUtil` and related input checks
- `45435ad` migrated the project template and reorganized build/mixin/access widener structure
- `1dbb9e1` updated Gradle and Loom
- `0518ba9` stopped the tuning GUI from opening when placing tagged note blocks
- `56bbf2d` removed a mixin that should live in a separate mod
- `6e79511` fixed a refmap typo
- `b92d49f` adjusted the Ctrl requirement behavior for opening the GUI
- `c580363` prepared the `1.21.11` Stonecutter target
- `0ae92ec` moved the project onto the new Stonecutter template and `rs256` package/build naming

## License

This fork is distributed under LGPLv3, not the upstream project's current GPLv3.

That is intentional. This repository was forked from upstream while the upstream codebase was still licensed under LGPLv3, and this fork has not synchronized commits from upstream after upstream changed its license to GPLv3.

Accordingly, this repository remains distributed under LGPLv3 based on the code snapshot it originally forked from. This does not imply that newer upstream code, or upstream changes made after the GPLv3 relicensing, are available under LGPLv3 here.

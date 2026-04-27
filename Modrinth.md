# BlockTuner pitchsmith

BlockTuner pitchsmith is a Fabric fork of the original [BlockTuner](https://github.com/xwjcool123/BlockTunerMod), adjusted for builders who spend more time repeatedly tuning note blocks.

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

## Required Dependencies

- [Fabric API](https://modrinth.com/mod/fabric-api)
- [YetAnotherConfigLib (YACL)](https://modrinth.com/mod/yacl)

## How to Use

- `Ctrl` + `Right click` on a note block to open the tuning UI
- Placing a note block while holding `Ctrl` also opens the UI automatically
- Hold `Ctrl` to show the note at the crosshair
- `Ctrl` + `Middle click` on note blocks to pick up readily tuned note blocks
- Right click note blocks with blaze rods to play them without tuning

## Credits

Original project: [xwjcool123/BlockTunerMod](https://github.com/xwjcool123/BlockTunerMod)

## License

Copyright (C) 2021, xwjcool;
Copyright (C) 2025, Lumine1909;
Copyright (c) 2026, rs256;

This fork is distributed under the GNU Lesser General Public License v3.0.

That is intentional. This repository was forked from upstream while the upstream codebase was still licensed under LGPLv3, and this fork has not synchronized commits from upstream after upstream changed its license to GPLv3.

Accordingly, this repository remains distributed under LGPLv3 based on the code snapshot it originally forked from. This does not imply that newer upstream code, or upstream changes made after the GPLv3 relicensing, are available under LGPLv3 here.

This program is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this program. If not, see <https://www.gnu.org/licenses/>.

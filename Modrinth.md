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

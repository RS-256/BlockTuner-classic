# BlockTuner Classic

## About

BlockTuner Classic is a Fabric fork of the original [BlockTuner](https://github.com/xwjcool123/BlockTunerMod).

This fork keeps the original note block tuning workflow, but is being developed as its own branch with different configuration and maintenance decisions.

If you are looking for the original project, the upstream repositories are:

- Fabric mod: [xwjcool123/BlockTunerMod](https://github.com/xwjcool123/BlockTunerMod)
- Datapack for older versions: [xwjcool123/blocktuner](https://github.com/xwjcool123/blocktuner)
- Forge port: [APeng215/BlockTuner-forge](https://github.com/APeng215/BlockTuner-forge)

## Instructions

### Installation

Put this mod in your `mods` folder.

This fork requires the following dependency mods:

- [Fabric API](https://modrinth.com/mod/fabric-api)
- [YetAnotherConfigLib (YACL)](https://modrinth.com/mod/yacl)

This mod also works on servers and require no client installation.

### How to Use BlockTuner

`Ctrl` + `Right click` on a note block to open up tuning UI. Placing a note block while holding `Ctrl` also opens the UI automatically.

`Ctrl` to show the note of the note block at crosshair.

`Ctrl` + `Middle click` on note blocks to pick up readily tuned note blocks.

Right click note blocks with blaze rods to play with right clicks without tuning.

> [!NOTE]
> - If you are using BlockTuner 1.0.0 (Minecraft 1.18.2) or lower, you don't need to hold `Ctrl` to open up the tuning UI. Instead, use `/blocktuner` to toggle this.
> - If you have Tweakeroo installed and have no access to the `Ctrl` key, please go to Tweakaroo configs, find `flexibleBlockPlacementOffset` under `Hot Keys` and set it to something else. e.g. `Right Alt`. Sorry for the inconvenience.

### Tuning UI

Top-right corner (from left to right)

* ![](https://xwj.cool/img/blocktuner/btWidget1.png) Play mode - toggle whether the GUI will turn off immediately upon clicking a note on the piano keyboard.
* ![](https://xwj.cool/img/blocktuner/btWidget2.png) Typing keyboard to piano keyboard - toggle whether you want to play the piano keyboard using your computer keyboard.
* ![](https://xwj.cool/img/blocktuner/btWidget3.png) MIDI Device - Click to cycle through available MIDI input devices. The icon shows red if the device is currently unavailable. This usually means it is being used by another program.

### Keyboard Mapping:
![](https://xwj.cool/img/blocktuner/keymap.png)

## Credits
### Localization
* Russian - [Felix14-v2](https://github.com/Felix14-v2) (Currently outdated)
* Japanese - [misaka10843](https://github.com/misaka10843) & [hakkaku](https://note.com/hakukak/)

### Original Project
* [xwjcool123/BlockTunerMod](https://github.com/xwjcool123/BlockTunerMod)

### Forge Port
* [A_Peng215](https://github.com/APeng215)

## License

Copyright (C) 2021, xwjcool;
Copyright (C) 2025, Lumine1909;
Copyright (c) 2026, rs256;

This program is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

This program is distributed in the hospe that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public License along with this program.  If not, see <https://www.gnu.org/licenses/>.

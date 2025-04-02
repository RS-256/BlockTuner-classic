/*
 *     Copyright (c) 2023, xwjcool.
 *     Copyright (c) 2025, Lumine1909.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package io.github.lumine1909.blocktuner.util;

import io.github.lumine1909.blocktuner.BlockTunerConfig;

public class NoteNames {

    public static String get(int note) {
        note %= 12;
        return get(note, BlockTunerConfig.getKeySignature());
    }

    public static String get(int note, int keySignature) {
        String noteName = "";
        switch (note) {
            case 0 -> {
                if (keySignature >= -1) {
                    noteName = "F♯";
                } else if (keySignature <= -3) {
                    noteName = "G♭";
                } else {
                    noteName = "F♯ | G♭";
                }
            }
            case 1 -> {
                if (keySignature >= 6) {
                    noteName = "F\ud834\udd2a";
                } else if (keySignature <= 4 && keySignature >= -6) {
                    noteName = "G";
                    if (keySignature >= 3 || keySignature <= -5) {
                        noteName = "G♮";
                    }
                } else if (keySignature == 5) {
                    noteName = "F\ud834\udd2a | G♮";
                } else {
                    noteName = "G♮ | A\ud834\udd2b";
                }
            }
            case 2 -> {
                if (keySignature >= 1) {
                    noteName = "G♯";
                } else if (keySignature <= -1) {
                    noteName = "A♭";
                } else {
                    noteName = "G♯ | A♭";
                }
            }
            case 3 -> {
                if (keySignature >= 7) {
                    noteName = "G\ud834\udd2a | A♮";
                } else if (keySignature >= -4) {
                    noteName = "A";
                    if (keySignature <= -3 || keySignature >= 5) {
                        noteName = "A♮";
                    }
                } else if (keySignature <= -6) {
                    noteName = "B\ud834\udd2b";
                } else {
                    noteName = "A♮ | B\ud834\udd2b";
                }
            }
            case 4 -> {
                if (keySignature >= 3) {
                    noteName = "A♯";
                } else if (keySignature <= 1) {
                    noteName = "B♭";
                } else {
                    noteName = "A♯ | B♭";
                }
            }
            case 5 -> {
                if (keySignature >= -2) {
                    noteName = "B";
                    if (keySignature <= -1 || keySignature >= 7) {
                        noteName = "B♮";
                    }
                } else if (keySignature <= -4) {
                    noteName = "C♭";
                } else {
                    noteName = "B♮ | C♭";
                }
            }
            case 6 -> {
                if (keySignature >= 5) {
                    noteName = "B♯";
                } else if (keySignature <= 3) {
                    noteName = "C";
                    if (keySignature >= 2 || keySignature <= -6) {
                        noteName = "C♮";
                    }
                } else {
                    noteName = "B♯ | C♮";
                }
            }
            case 7 -> {
                if (keySignature >= 0) {
                    noteName = "C♯";
                } else if (keySignature <= -2) {
                    noteName = "D♭";
                } else {
                    noteName = "C♯ | D♭";
                }
            }
            case 8 -> {
                if (keySignature >= 7) {
                    noteName = "C\ud834\udd2a";
                } else if (keySignature >= -5 && keySignature <= 5) {
                    noteName = "D";
                    if (keySignature <= -4 || keySignature >= 4) {
                        noteName = "D♮";
                    }
                } else if (keySignature <= -7) {
                    noteName = "E\ud834\udd2b";
                } else if (keySignature == -6) {
                    noteName = "C\ud834\udd2a | D♮";
                } else {
                    noteName = "D♮ | E\ud834\udd2b";
                }
            }
            case 9 -> {
                if (keySignature >= 2) {
                    noteName = "D♯";
                } else if (keySignature <= 0) {
                    noteName = "E♭";
                } else {
                    noteName = "D♯ | E♭";
                }
            }
            case 10 -> {
                if (keySignature >= -3) {
                    noteName = "E";
                    if (keySignature <= -2 || keySignature >= 6) {
                        noteName = "E♮";
                    }
                } else if (keySignature <= -5) {
                    noteName = "F♭";
                } else {
                    noteName = "E♮ | F♭";
                }
            }
            case 11 -> {
                if (keySignature >= 4) {
                    noteName = "E♯";
                } else if (keySignature <= 2) {
                    noteName = "F";
                    if (keySignature >= 1 || keySignature <= -7) {
                        noteName = "F♮";
                    }
                } else {
                    noteName = "E♯ | F♮";
                }
            }
        }
        return noteName;
    }
}
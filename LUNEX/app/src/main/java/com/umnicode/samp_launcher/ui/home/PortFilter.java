package com.umnicode.samp_launcher.ui.home;

import android.text.InputFilter;
import android.text.Spanned;

public class PortFilter implements InputFilter {
    private final int Min;
    private final int Max;

    public PortFilter() {
        this(0, 65535);
    }

    public PortFilter(int min, int max) {
        this.Min = min;
        this.Max = max;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dStart, int dEnd) {
        String candidate = dest.subSequence(0, dStart).toString()
                + source.subSequence(start, end)
                + dest.subSequence(dEnd, dest.length());

        // An empty field is valid while the user is editing.
        if (candidate.isEmpty()) return null;

        try {
            long value = Long.parseLong(candidate);
            if (value >= Min && value <= Max) return null;
        } catch (NumberFormatException ignored) {
            // Reject non-numeric or overflowing values.
        }
        return "";
    }

    public static boolean IsInRange(int number, int min, int max) {
        return number >= min && number <= max;
    }
}

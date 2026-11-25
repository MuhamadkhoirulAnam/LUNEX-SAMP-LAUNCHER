package com.umnicode.samp_launcher.ui.settings;

import android.text.InputFilter;
import android.text.Spanned;

public class PingTimeoutFilter implements InputFilter {
    private final int Min;

    public PingTimeoutFilter() {
        this(1);
    }

    public PingTimeoutFilter(int min) {
        this.Min = min;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end,
                               Spanned dest, int dStart, int dEnd) {
        String candidate = dest.subSequence(0, dStart).toString()
                + source.subSequence(start, end)
                + dest.subSequence(dEnd, dest.length());
        if (candidate.isEmpty()) return null;

        try {
            long value = Long.parseLong(candidate);
            if (value >= Min && value <= Integer.MAX_VALUE) return null;
        } catch (NumberFormatException ignored) {
            // Reject non-numeric or overflowing values.
        }
        return "";
    }
}

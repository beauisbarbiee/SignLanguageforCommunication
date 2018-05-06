package beauisbarbie.scl.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.ImageView;

import beauisbarbie.scl.Home01Fragment;
import beauisbarbie.scl.Home02Fragment;
import beauisbarbie.scl.Home03Fragment;

public class AdapterHomeActivity extends FragmentStatePagerAdapter {

    public AdapterHomeActivity(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        if(position == 0)
            return new Home01Fragment();
        else if(position == 1)
            return new Home02Fragment();
        else if(position == 2)
            return new Home03Fragment();
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

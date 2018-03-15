// Generated code from Butter Knife. Do not modify!
package com.example.android.sensorsurvey;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.list = Utils.findRequiredViewAsType(source, R.id.sensor_list, "field 'list'", TextView.class);
    target.proximity = Utils.findRequiredViewAsType(source, R.id.sensor_proximity, "field 'proximity'", TextView.class);
    target.light = Utils.findRequiredViewAsType(source, R.id.sensor_light, "field 'light'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.list = null;
    target.proximity = null;
    target.light = null;
  }
}

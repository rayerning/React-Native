package com.danademo;

import android.util.Log;

import com.facebook.react.LazyReactPackage;
import com.facebook.react.animated.NativeAnimatedModule;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModuleList;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.accessibilityinfo.AccessibilityInfoModule;
import com.facebook.react.modules.appstate.AppStateModule;
import com.facebook.react.modules.blob.FileReaderModule;
import com.facebook.react.modules.camera.CameraRollManager;
import com.facebook.react.modules.camera.ImageEditingManager;
import com.facebook.react.modules.camera.ImageStoreManager;
import com.facebook.react.modules.clipboard.ClipboardModule;
import com.facebook.react.modules.datepicker.DatePickerDialogModule;
import com.facebook.react.modules.dialog.DialogModule;
import com.facebook.react.modules.fresco.FrescoModule;
import com.facebook.react.modules.i18nmanager.I18nManagerModule;
import com.facebook.react.modules.image.ImageLoaderModule;
import com.facebook.react.modules.intent.IntentModule;
import com.facebook.react.modules.location.LocationModule;
import com.facebook.react.modules.netinfo.NetInfoModule;
import com.facebook.react.modules.network.OkHttpClientProvider;
import com.facebook.react.modules.network.ReactCookieJarContainer;
import com.facebook.react.modules.permissions.PermissionsModule;
import com.facebook.react.modules.share.ShareModule;
import com.facebook.react.modules.statusbar.StatusBarModule;
import com.facebook.react.modules.storage.AsyncStorageModule;
import com.facebook.react.modules.timepicker.TimePickerDialogModule;
import com.facebook.react.modules.toast.ToastModule;
import com.facebook.react.modules.vibration.VibrationModule;
import com.facebook.react.modules.websocket.WebSocketModule;
import com.facebook.react.shell.MainPackageConfig;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.art.ARTRenderableViewManager;
import com.facebook.react.views.art.ARTSurfaceViewManager;
import com.facebook.react.views.checkbox.ReactCheckBoxManager;
import com.facebook.react.views.drawer.ReactDrawerLayoutManager;
import com.facebook.react.views.image.ReactImageManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.facebook.react.views.picker.ReactDialogPickerManager;
import com.facebook.react.views.picker.ReactDropdownPickerManager;
import com.facebook.react.views.progressbar.ReactProgressBarViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager;
import com.facebook.react.views.scroll.ReactHorizontalScrollViewManager;
import com.facebook.react.views.scroll.ReactScrollViewManager;
import com.facebook.react.views.slider.ReactSliderManager;
import com.facebook.react.views.swiperefresh.SwipeRefreshLayoutManager;
import com.facebook.react.views.switchview.ReactSwitchManager;
import com.facebook.react.views.text.ReactRawTextManager;
import com.facebook.react.views.text.ReactTextViewManager;
import com.facebook.react.views.text.ReactVirtualTextViewManager;
import com.facebook.react.views.text.frescosupport.FrescoBasedReactTextInlineImageViewManager;
import com.facebook.react.views.textinput.ReactTextInputManager;
import com.facebook.react.views.toolbar.ReactToolbarManager;
import com.facebook.react.views.view.ReactViewManager;
import com.facebook.react.views.viewpager.ReactViewPagerManager;
import com.facebook.react.views.webview.ReactWebViewManager;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Provider;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.OkHttpClient;
/**
 * Copyright (c) Facebook, Inc. and its affiliates.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */

/**
 * Package defining basic modules and view managers.
 */
@ReactModuleList(nativeModules = {
        AccessibilityInfoModule.class,
        AppStateModule.class,
        BlobModule.class,
        FileReaderModule.class,
        AsyncStorageModule.class,
        CameraRollManager.class,
        ClipboardModule.class,
        DatePickerDialogModule.class,
        DialogModule.class,
        FrescoModule.class,
        I18nManagerModule.class,
        ImageEditingManager.class,
        ImageLoaderModule.class,
        ImageStoreManager.class,
        IntentModule.class,
        LocationModule.class,
        NativeAnimatedModule.class,
        NetworkingModule.class,
        NetInfoModule.class,
        PermissionsModule.class,
        ShareModule.class,
        StatusBarModule.class,
        TimePickerDialogModule.class,
        ToastModule.class,
        VibrationModule.class,
        WebSocketModule.class,

})
public class MyMainReactPackage extends LazyReactPackage {

    private MainPackageConfig mConfig;

    public MyMainReactPackage() {
    }

    /**
     * Create a new package with configuration
     */
    public MyMainReactPackage(MainPackageConfig config) {
        mConfig = config;
    }

    @Override
    public List<ModuleSpec> getNativeModules(final ReactApplicationContext context) {
        return Arrays.asList(
                ModuleSpec.nativeModuleSpec(
                        AccessibilityInfoModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new AccessibilityInfoModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        AppStateModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new AppStateModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        BlobModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new BlobModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        FileReaderModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new FileReaderModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        AsyncStorageModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new AsyncStorageModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        CameraRollManager.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new CameraRollManager(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ClipboardModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ClipboardModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        DatePickerDialogModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new DatePickerDialogModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        DialogModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new DialogModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        FrescoModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new FrescoModule(
                                        context, true, mConfig != null ? mConfig.getFrescoConfig() : null);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        I18nManagerModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new I18nManagerModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ImageEditingManager.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ImageEditingManager(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ImageLoaderModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ImageLoaderModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ImageStoreManager.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ImageStoreManager(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        IntentModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new IntentModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        LocationModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new LocationModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        NativeAnimatedModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new NativeAnimatedModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        NetworkingModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new NetworkingModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        NetInfoModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new NetInfoModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        PermissionsModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new PermissionsModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ShareModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ShareModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        StatusBarModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new StatusBarModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        TimePickerDialogModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new TimePickerDialogModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        ToastModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new ToastModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        VibrationModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new VibrationModule(context);
                            }
                        }),
                ModuleSpec.nativeModuleSpec(
                        WebSocketModule.class,
                        new Provider<NativeModule>() {
                            @Override
                            public NativeModule get() {
                                return new WebSocketModule(context);
                            }
                        }));
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        List<ViewManager> viewManagers = new ArrayList<>();

        viewManagers.add(ARTRenderableViewManager.createARTGroupViewManager());
        viewManagers.add(ARTRenderableViewManager.createARTShapeViewManager());
        viewManagers.add(ARTRenderableViewManager.createARTTextViewManager());
        viewManagers.add(new ReactCheckBoxManager());
        viewManagers.add(new ReactDialogPickerManager());
        viewManagers.add(new ReactDrawerLayoutManager());
        viewManagers.add(new ReactDropdownPickerManager());
        viewManagers.add(new ReactHorizontalScrollViewManager());
        viewManagers.add(new ReactHorizontalScrollContainerViewManager());
        viewManagers.add(new ReactProgressBarViewManager());
        viewManagers.add(new ReactScrollViewManager());
        viewManagers.add(new ReactSliderManager());
        viewManagers.add(new ReactSwitchManager());
        viewManagers.add(new ReactToolbarManager());
        viewManagers.add(new ReactWebViewManager());
        viewManagers.add(new SwipeRefreshLayoutManager());

        // Native equivalents
        viewManagers.add(new ARTSurfaceViewManager());
        viewManagers.add(new FrescoBasedReactTextInlineImageViewManager());
        viewManagers.add(new ReactImageManager());
        viewManagers.add(new ReactModalHostManager());
        viewManagers.add(new ReactRawTextManager());
        viewManagers.add(new ReactTextInputManager());
        viewManagers.add(new ReactTextViewManager());
        viewManagers.add(new ReactViewManager());
        viewManagers.add(new ReactViewPagerManager());
        viewManagers.add(new ReactVirtualTextViewManager());

        return viewManagers;
    }

    @Override
    public ReactModuleInfoProvider getReactModuleInfoProvider() {
        // This has to be done via reflection or we break open source.
        return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
    }

    // 证书认证

    private void setCertificates(OkHttpClient.Builder client, InputStream... certificates) {
        try{
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
//            for(InputStream certificate : certificates) {
//                String certificateAlias = Integer.toString(index++);
//                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));
//                if(certificate != null) {
//                    certificate.close();
//                }
//            }
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            sslContext.init(
                    null,
                    trustManagerFactory.getTrustManagers(),
                    new SecureRandom()
            );
            client.sslSocketFactory(sslContext.getSocketFactory());
        }catch (Exception e) {
            Log.d("===", e.getMessage());
            e.printStackTrace();
        }
    }

// 设置client对象并替换

    public void httpsSetting() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(30 * 1000, TimeUnit.MILLISECONDS)
                .cookieJar(new ReactCookieJarContainer());
//        try{
//            setCertificates(client, mContext.getAssets().open("这里填你放入assets目录下的cer文件名（test.cer）"));
        client.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                // hostname 为服务器地址。ip或域名
                Log.d("============", hostname);
                return true;
            }
        });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        OkHttpClient.Builder builder = OkHttpClientProvider.enableTls12OnPreLollipop(client);
        // 将上面设置了认证的client对象替换
        OkHttpClientProvider.replaceOkHttpClient(builder.build());
    }
}

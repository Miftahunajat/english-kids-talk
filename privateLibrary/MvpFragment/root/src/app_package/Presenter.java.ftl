package ${packageName};

public class ${className}Presenter<V extends ${className}MvpView> extends BasePresenter<V>
        implements ${className}MvpPresenter<V> {

    private static final String TAG = "${className}Presenter";

    @Inject
    public ${className}Presenter(DataManager dataManager,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }
    
}

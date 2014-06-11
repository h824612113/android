package org.jetbrains.android.inspections.lint;

import com.android.SdkConstants;
import com.android.tools.lint.checks.*;
import com.android.tools.lint.detector.api.Issue;
import com.intellij.codeInsight.intention.IntentionAction;
import com.intellij.openapi.editor.Editor;
import com.intellij.psi.PsiElement;
import org.jetbrains.android.util.AndroidBundle;
import org.jetbrains.annotations.NotNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.android.tools.lint.checks.FragmentDetector.ISSUE;
import static com.android.tools.lint.checks.PluralsDetector.IMPLIED_QUANTITY;

/**
 * @author Eugene.Kudelevsky
 */
public class AndroidLintInspectionToolProvider {
  public static class AndroidLintAaptCrashInspection extends AndroidLintInspectionBase {
    public AndroidLintAaptCrashInspection() {
      super(AndroidBundle.message("android.lint.inspections.aapt.crash"), ResourceCycleDetector.CRASH);
    }
  }
  public static class AndroidLintInconsistentArraysInspection extends AndroidLintInspectionBase {
    public AndroidLintInconsistentArraysInspection() {
      super(AndroidBundle.message("android.lint.inspections.inconsistent.arrays"), ArraySizeDetector.INCONSISTENT);
    }
  }

  public static class AndroidLintInconsistentLayoutInspection extends AndroidLintInspectionBase {
    public AndroidLintInconsistentLayoutInspection() {
      super(AndroidBundle.message("android.lint.inspections.inconsistent.layout"), LayoutConsistencyDetector.INCONSISTENT_IDS);
    }
  }

  public static class AndroidLintDuplicateIncludedIdsInspection extends AndroidLintInspectionBase {
    public AndroidLintDuplicateIncludedIdsInspection() {
      super(AndroidBundle.message("android.lint.inspections.duplicate.included.ids"), DuplicateIdDetector.CROSS_LAYOUT);
    }
  }

  public static class AndroidLintIconExpectedSizeInspection extends AndroidLintInspectionBase {
    public AndroidLintIconExpectedSizeInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.expected.size"), IconDetector.ICON_EXPECTED_SIZE);
    }
  }

  public static class AndroidLintIconDipSizeInspection extends AndroidLintInspectionBase {
    public AndroidLintIconDipSizeInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.dip.size"), IconDetector.ICON_DIP_SIZE);
    }
  }

  public static class AndroidLintIconLocationInspection extends AndroidLintInspectionBase {
    public AndroidLintIconLocationInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.location"), IconDetector.ICON_LOCATION);
    }
  }

  public static class AndroidLintIconDensitiesInspection extends AndroidLintInspectionBase {
    public AndroidLintIconDensitiesInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.densities"), IconDetector.ICON_DENSITIES);
    }
  }

  public static class AndroidLintIconMissingDensityFolderInspection extends AndroidLintInspectionBase {
    public AndroidLintIconMissingDensityFolderInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.missing.density.folder"), IconDetector.ICON_MISSING_FOLDER);
    }
  }

  public static class AndroidLintIconMixedNinePatchInspection extends AndroidLintInspectionBase {
    public AndroidLintIconMixedNinePatchInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.mixed.nine.patch"), IconDetector.ICON_MIX_9PNG);
    }
  }

  public static class AndroidLintGifUsageInspection extends AndroidLintInspectionBase {
    public AndroidLintGifUsageInspection() {
      super(AndroidBundle.message("android.lint.inspections.gif.usage"), IconDetector.GIF_USAGE);
    }
  }

  public static class AndroidLintIconDuplicatesInspection extends AndroidLintInspectionBase {
    public AndroidLintIconDuplicatesInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.duplicates"), IconDetector.DUPLICATES_NAMES);
    }
  }

  public static class AndroidLintIconDuplicatesConfigInspection extends AndroidLintInspectionBase {
    public AndroidLintIconDuplicatesConfigInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.duplicates.config"), IconDetector.DUPLICATES_CONFIGURATIONS);
    }
  }

  public static class AndroidLintIconNoDpiInspection extends AndroidLintInspectionBase {
    public AndroidLintIconNoDpiInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.no.dpi"), IconDetector.ICON_NODPI);
    }
  }

  public static class AndroidLintOverdrawInspection extends AndroidLintInspectionBase {
    public AndroidLintOverdrawInspection() {
      super(AndroidBundle.message("android.lint.inspections.overdraw"), OverdrawDetector.ISSUE);
    }
  }

  public static class AndroidLintMissingSuperCallInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingSuperCallInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.super.call"), CallSuperDetector.ISSUE);
    }
  }

  public static class AndroidLintMissingTranslationInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingTranslationInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.translation"), TranslationDetector.MISSING);
    }
  }

  public static class AndroidLintExtraTranslationInspection extends AndroidLintInspectionBase {
    public AndroidLintExtraTranslationInspection() {
      super(AndroidBundle.message("android.lint.inspections.extra.translation"), TranslationDetector.EXTRA);
    }
  }

  public static class AndroidLintUnusedResourcesInspection extends AndroidLintInspectionBase {
    public AndroidLintUnusedResourcesInspection() {
      super(AndroidBundle.message("android.lint.inspections.unused.resources"), UnusedResourceDetector.ISSUE);
    }
  }

  public static class AndroidLintUnusedAttributeInspection extends AndroidLintInspectionBase {
    public AndroidLintUnusedAttributeInspection() {
      super(AndroidBundle.message("android.lint.inspections.unused.attribute"), ApiDetector.UNUSED);
    }
  }

  public static class AndroidLintUnusedIdsInspection extends AndroidLintInspectionBase {
    public AndroidLintUnusedIdsInspection() {
      super(AndroidBundle.message("android.lint.inspections.unused.ids"), UnusedResourceDetector.ISSUE_IDS);
    }
  }

  public static class AndroidLintAlwaysShowActionInspection extends AndroidLintInspectionBase {
    public AndroidLintAlwaysShowActionInspection() {
      super(AndroidBundle.message("android.lint.inspections.always.show.action"), AlwaysShowActionDetector.ISSUE);
    }
  }

  public static class AndroidLintAppCompatMethodInspection extends AndroidLintInspectionBase {
    public AndroidLintAppCompatMethodInspection() {
      super(AndroidBundle.message("android.lint.inspections.app.compat.method"), AppCompatCallDetector.ISSUE);
    }
  }

  public static class AndroidLintAppCompatResourceInspection extends AndroidLintInspectionBase {
    public AndroidLintAppCompatResourceInspection() {
      super(AndroidBundle.message("android.lint.inspections.app.compat.resource"), AppCompatResourceDetector.ISSUE);
    }
  }

  public static class AndroidLintAssertInspection extends AndroidLintInspectionBase {
    public AndroidLintAssertInspection() {
      super(AndroidBundle.message("android.lint.inspections.assert"), AssertDetector.ISSUE);
    }
  }

  public static class AndroidLintStringFormatCountInspection extends AndroidLintInspectionBase {
    public AndroidLintStringFormatCountInspection() {
      super(AndroidBundle.message("android.lint.inspections.string.format.count"), StringFormatDetector.ARG_COUNT);
    }
  }

  public static class AndroidLintStringFormatMatchesInspection extends AndroidLintInspectionBase {
    public AndroidLintStringFormatMatchesInspection() {
      super(AndroidBundle.message("android.lint.inspections.string.format.matches"), StringFormatDetector.ARG_TYPES);
    }
  }

  public static class AndroidLintStringFormatInvalidInspection extends AndroidLintInspectionBase {
    public AndroidLintStringFormatInvalidInspection() {
      super(AndroidBundle.message("android.lint.inspections.string.format.invalid"), StringFormatDetector.INVALID);
    }
  }

  public static class AndroidLintWrongViewCastInspection extends AndroidLintInspectionBase {
    public AndroidLintWrongViewCastInspection() {
      super(AndroidBundle.message("android.lint.inspections.wrong.view.cast"), ViewTypeDetector.ISSUE);
    }
  }

  public static class AndroidLintUnknownIdInspection extends AndroidLintInspectionBase {
    public AndroidLintUnknownIdInspection() {
      super(AndroidBundle.message("android.lint.inspections.unknown.id"), WrongIdDetector.UNKNOWN_ID);
    }
  }

  /**
   * Local inspections processed by AndroidLintExternalAnnotator
   */
  public static class AndroidLintContentDescriptionInspection extends AndroidLintInspectionBase {
    public AndroidLintContentDescriptionInspection() {
      super(AndroidBundle.message("android.lint.inspections.content.description"), AccessibilityDetector.ISSUE);
    }

    @Override
    @NotNull
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{
        new SetAttributeQuickFix(AndroidBundle.message("android.lint.fix.add.content.description"),
                                 SdkConstants.ATTR_CONTENT_DESCRIPTION, null)
      };
    }
  }

  public static class AndroidLintButtonOrderInspection extends AndroidLintInspectionBase {
    public AndroidLintButtonOrderInspection() {
      super(AndroidBundle.message("android.lint.inspections.button.order"), ButtonDetector.ORDER);
    }
  }

  public static class AndroidLintBackButtonInspection extends AndroidLintInspectionBase {
    public AndroidLintBackButtonInspection() {
      super(AndroidBundle.message("android.lint.inspections.back.button"), ButtonDetector.BACK_BUTTON);
    }
  }

  public static class AndroidLintButtonCaseInspection extends AndroidLintInspectionBase {
    public AndroidLintButtonCaseInspection() {
      super(AndroidBundle.message("android.lint.inspections.button.case"), ButtonDetector.CASE);
    }
  }

  public static class AndroidLintResourceAsColorInspection extends AndroidLintInspectionBase {
    public AndroidLintResourceAsColorInspection() {
      super(AndroidBundle.message("android.lint.inspections.resource.as.color"), ColorUsageDetector.ISSUE);
    }
  }

  public static class AndroidLintExtraTextInspection extends AndroidLintInspectionBase {
    public AndroidLintExtraTextInspection() {
      super(AndroidBundle.message("android.lint.inspections.extra.text"), ExtraTextDetector.ISSUE);
    }
  }

  public static class AndroidLintHardcodedDebugModeInspection extends AndroidLintInspectionBase {
    public AndroidLintHardcodedDebugModeInspection() {
      super(AndroidBundle.message("android.lint.inspections.hardcoded.debug.mode"), HardcodedDebugModeDetector.ISSUE);
    }
  }

  public static class AndroidLintDrawAllocationInspection extends AndroidLintInspectionBase {
    public AndroidLintDrawAllocationInspection() {
      super(AndroidBundle.message("android.lint.inspections.draw.allocation"), JavaPerformanceDetector.PAINT_ALLOC);
    }
  }

  public static class AndroidLintUseSparseArraysInspection extends AndroidLintInspectionBase {
    public AndroidLintUseSparseArraysInspection() {
      super(AndroidBundle.message("android.lint.inspections.use.sparse.arrays"), JavaPerformanceDetector.USE_SPARSE_ARRAY);
    }
  }

  public static class AndroidLintUseValueOfInspection extends AndroidLintInspectionBase {
    public AndroidLintUseValueOfInspection() {
      super(AndroidBundle.message("android.lint.inspections.use.value.of"), JavaPerformanceDetector.USE_VALUE_OF);
    }
  }

  public static class AndroidLintLibraryCustomViewInspection extends AndroidLintInspectionBase {
    public AndroidLintLibraryCustomViewInspection() {
      super(AndroidBundle.message("android.lint.inspections.library.custom.view"), NamespaceDetector.CUSTOM_VIEW);
    }
  }

  public static class AndroidLintParcelCreatorInspection extends AndroidLintInspectionBase {
    public AndroidLintParcelCreatorInspection() {
      super(AndroidBundle.message("android.lint.inspections.parcel.creator"), ParcelDetector.ISSUE);
    }
  }

  public static class AndroidLintPrivateResourceInspection extends AndroidLintInspectionBase {
    public AndroidLintPrivateResourceInspection() {
      super(AndroidBundle.message("android.lint.inspections.private.resource"), PrivateResourceDetector.ISSUE);
    }
  }

  public static class AndroidLintSdCardPathInspection extends AndroidLintInspectionBase {
    public AndroidLintSdCardPathInspection() {
      super(AndroidBundle.message("android.lint.inspections.sd.card.path"), SdCardDetector.ISSUE);
    }
  }

  public static class AndroidLintTextViewEditsInspection extends AndroidLintInspectionBase {
    public AndroidLintTextViewEditsInspection() {
      super(AndroidBundle.message("android.lint.inspections.text.view.edits"), TextViewDetector.ISSUE);
    }
  }

  public static class AndroidLintEnforceUTF8Inspection extends AndroidLintInspectionBase {
    public AndroidLintEnforceUTF8Inspection() {
      super(AndroidBundle.message("android.lint.inspections.enforce.utf8"), Utf8Detector.ISSUE);
    }
  }

  public static class AndroidLintUnknownIdInLayoutInspection extends AndroidLintInspectionBase {
    public AndroidLintUnknownIdInLayoutInspection() {
      super(AndroidBundle.message("android.lint.inspections.unknown.id.in.layout"), WrongIdDetector.UNKNOWN_ID_LAYOUT);
    }
  }

  public static class AndroidLintSuspiciousImportInspection extends AndroidLintInspectionBase {
    public AndroidLintSuspiciousImportInspection() {
      super(AndroidBundle.message("android.lint.inspections.suspicious.import"), WrongImportDetector.ISSUE);
    }
  }

  public static class AndroidLintAccidentalOctalInspection extends AndroidLintInspectionBase {
    public AndroidLintAccidentalOctalInspection() {
      super(AndroidBundle.message("android.lint.inspections.accidental.octal"), GradleDetector.ACCIDENTAL_OCTAL);
    }
  }

  public static class AndroidLintAdapterViewChildrenInspection extends AndroidLintInspectionBase {
    public AndroidLintAdapterViewChildrenInspection() {
      super(AndroidBundle.message("android.lint.inspections.adapter.view.children"), ChildCountDetector.ADAPTER_VIEW_ISSUE);
    }
  }

  public static class AndroidLintScrollViewCountInspection extends AndroidLintInspectionBase {
    public AndroidLintScrollViewCountInspection() {
      super(AndroidBundle.message("android.lint.inspections.scroll.view.count"), ChildCountDetector.SCROLLVIEW_ISSUE);
    }
  }

  // it seems we don't need it because we have our own 'deprecated api' inspection
  // TODO: Double check this; Lint's deprecations are for XML; does IntelliJ check that?
  /*public static class AndroidLintDeprecatedInspection extends AndroidLintInspectionBase {
    public AndroidLintDeprecatedInspection() {
      super(AndroidBundle.message("android.lint.inspections.deprecated"), DeprecationDetector.ISSUE);
    }
  }*/

  public static class AndroidLintMissingPrefixInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingPrefixInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.prefix"), DetectMissingPrefix.MISSING_NAMESPACE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new AddMissingPrefixQuickFix()};
    }
  }

  public static class AndroidLintMissingQuantityInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingQuantityInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.quantity"), PluralsDetector.MISSING);
    }
  }

  public static class AndroidLintUnusedQuantityInspection extends AndroidLintInspectionBase {
    public AndroidLintUnusedQuantityInspection() {
      super(AndroidBundle.message("android.lint.inspections.unused.quantity"), PluralsDetector.EXTRA);
    }
  }

  public static class AndroidLintDuplicateIdsInspection extends AndroidLintInspectionBase {
    public AndroidLintDuplicateIdsInspection() {
      super(AndroidBundle.message("android.lint.inspections.duplicate.ids"), DuplicateIdDetector.WITHIN_LAYOUT);
    }
  }

  public static class AndroidLintGridLayoutInspection extends AndroidLintInspectionBase {
    public AndroidLintGridLayoutInspection() {
      super(AndroidBundle.message("android.lint.inspections.grid.layout"), GridLayoutDetector.ISSUE);
    }
  }

  public static class AndroidLintHardcodedTextInspection extends AndroidLintInspectionBase {
    public AndroidLintHardcodedTextInspection() {
      super(AndroidBundle.message("android.lint.inspections.hardcoded.text"), HardcodedValuesDetector.ISSUE);
    }

    @NotNull
    @Override
    public IntentionAction[] getIntentions(@NotNull final PsiElement startElement, @NotNull PsiElement endElement) {
      return new IntentionAction[]{new AndroidAddStringResourceQuickFix(startElement)};
    }
  }

  public static class AndroidLintInefficientWeightInspection extends AndroidLintInspectionBase {
    public AndroidLintInefficientWeightInspection() {
      super(AndroidBundle.message("android.lint.inspections.inefficient.weight"), InefficientWeightDetector.INEFFICIENT_WEIGHT);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{
        new InefficientWeightQuickFix()
      };
    }
  }

  public static class AndroidLintNestedWeightsInspection extends AndroidLintInspectionBase {
    public AndroidLintNestedWeightsInspection() {
      super(AndroidBundle.message("android.lint.inspections.nested.weights"), InefficientWeightDetector.NESTED_WEIGHTS);
    }
  }

  public static class AndroidLintDeviceAdminInspection extends AndroidLintInspectionBase {
    public AndroidLintDeviceAdminInspection() {
      super(AndroidBundle.message("android.lint.inspections.device.admin"), ManifestDetector.DEVICE_ADMIN);
    }
  }

  public static class AndroidLintDisableBaselineAlignmentInspection extends AndroidLintInspectionBase {
    public AndroidLintDisableBaselineAlignmentInspection() {
      super(AndroidBundle.message("android.lint.inspections.disable.baseline.alignment"), InefficientWeightDetector.BASELINE_WEIGHTS);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{
        new SetAttributeQuickFix(AndroidBundle.message("android.lint.fix.set.baseline.attribute"),
                                 SdkConstants.ATTR_BASELINE_ALIGNED, "false")
      };
    }
  }

  public static class AndroidLintManifestOrderInspection extends AndroidLintInspectionBase {
    public AndroidLintManifestOrderInspection() {
      super(AndroidBundle.message("android.lint.inspections.manifest.order"), ManifestDetector.ORDER);
    }
  }

  public static class AndroidLintMockLocationInspection extends AndroidLintInspectionBase {
    public AndroidLintMockLocationInspection() {
      super(AndroidBundle.message("android.lint.inspections.mock.location"), ManifestDetector.MOCK_LOCATION);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new MoveToDebugManifestQuickFix()};
    }
  }

  public static class AndroidLintMultipleUsesSdkInspection extends AndroidLintInspectionBase {
    public AndroidLintMultipleUsesSdkInspection() {
      super(AndroidBundle.message("android.lint.inspections.multiple.uses.sdk"), ManifestDetector.MULTIPLE_USES_SDK);
    }
  }

  public static class AndroidLintUsesMinSdkAttributesInspection extends AndroidLintInspectionBase {
    public AndroidLintUsesMinSdkAttributesInspection() {
      super(AndroidBundle.message("android.lint.inspections.uses.min.sdk.attributes"), ManifestDetector.USES_SDK);
    }
  }

  public static class AndroidLintValidFragmentInspection extends AndroidLintInspectionBase {
    public AndroidLintValidFragmentInspection() {
      super(AndroidBundle.message("android.lint.inspections.valid.fragment"), ISSUE);
    }
  }

  public static class AndroidLintViewConstructorInspection extends AndroidLintInspectionBase {
    public AndroidLintViewConstructorInspection() {
      super(AndroidBundle.message("android.lint.inspections.view.constructor"), ViewConstructorDetector.ISSUE);
    }
  }

  public static class AndroidLintViewHolderInspection extends AndroidLintInspectionBase {
    public AndroidLintViewHolderInspection() {
      super(AndroidBundle.message("android.lint.inspections.view.holder"), ViewHolderDetector.ISSUE);
    }
  }

  public static class AndroidLintWebViewLayoutInspection extends AndroidLintInspectionBase {
    public AndroidLintWebViewLayoutInspection() {
      super(AndroidBundle.message("android.lint.inspections.web.view.layout"), WebViewDetector.ISSUE);
    }
  }

  public static class AndroidLintMergeRootFrameInspection extends AndroidLintInspectionBase {
    public AndroidLintMergeRootFrameInspection() {
      super(AndroidBundle.message("android.lint.inspections.merge.root.frame"), MergeRootFrameLayoutDetector.ISSUE);
    }
  }

  public static class AndroidLintNestedScrollingInspection extends AndroidLintInspectionBase {
    public AndroidLintNestedScrollingInspection() {
      super(AndroidBundle.message("android.lint.inspections.nested.scrolling"), NestedScrollingWidgetDetector.ISSUE);
    }
  }

  public static class AndroidLintNewerVersionAvailableInspection extends AndroidLintInspectionBase {
    public AndroidLintNewerVersionAvailableInspection() {
      super(AndroidBundle.message("android.lint.inspections.newer.version.available"), GradleDetector.REMOTE_VERSION);
    }
  }

  public static class AndroidLintNfcTechWhitespaceInspection extends AndroidLintInspectionBase {
    public AndroidLintNfcTechWhitespaceInspection() {
      super(AndroidBundle.message("android.lint.inspections.nfc.tech.whitespace"), NfcTechListDetector.ISSUE);
    }
  }

  public static class AndroidLintNotSiblingInspection extends AndroidLintInspectionBase {
    public AndroidLintNotSiblingInspection() {
      super(AndroidBundle.message("android.lint.inspections.not.sibling"), WrongIdDetector.NOT_SIBLING);
    }
  }

  public static class AndroidLintObsoleteLayoutParamInspection extends AndroidLintInspectionBase {
    public AndroidLintObsoleteLayoutParamInspection() {
      super(AndroidBundle.message("android.lint.inspections.obsolete.layout.param"), ObsoleteLayoutParamsDetector.ISSUE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new RemoveAttributeQuickFix()};
    }
  }

  public static class AndroidLintProguardInspection extends AndroidLintInspectionBase {
    public AndroidLintProguardInspection() {
      super(AndroidBundle.message("android.lint.inspections.proguard"), ProguardDetector.WRONG_KEEP);
    }
  }

  public static class AndroidLintProguardSplitInspection extends AndroidLintInspectionBase {
    public AndroidLintProguardSplitInspection() {
      super(AndroidBundle.message("android.lint.inspections.proguard.split"), ProguardDetector.SPLIT_CONFIG);
    }
  }

  public static class AndroidLintPxUsageInspection extends AndroidLintInspectionBase {
    public AndroidLintPxUsageInspection() {
      super(AndroidBundle.message("android.lint.inspections.px.usage"), PxUsageDetector.PX_ISSUE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new ConvertToDpQuickFix()};
    }
  }

  public static class AndroidLintScrollViewSizeInspection extends AndroidLintInspectionBase {
    public AndroidLintScrollViewSizeInspection() {
      super(AndroidBundle.message("android.lint.inspections.scroll.view.size"), ScrollViewChildDetector.ISSUE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new SetScrollViewSizeQuickFix()};
    }
  }

  public static class AndroidLintExportedServiceInspection extends AndroidLintInspectionBase {
    public AndroidLintExportedServiceInspection() {
      super(AndroidBundle.message("android.lint.inspections.exported.service"), SecurityDetector.EXPORTED_SERVICE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{
        new SetAttributeQuickFix(AndroidBundle.message("android.lint.fix.add.permission.attribute"),
                                 SdkConstants.ATTR_PERMISSION, null)
      };
    }
  }

  public static class AndroidLintGradleCompatibleInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleCompatibleInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.compatible"), GradleDetector.COMPATIBILITY);
    }
  }

  public static class AndroidLintGradleDependencyInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleDependencyInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.dependency"), GradleDetector.DEPENDENCY);
    }
  }

  public static class AndroidLintGradleDynamicVersionInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleDynamicVersionInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.dynamic.version"), GradleDetector.PLUS);
    }
  }

  public static class AndroidLintGradleGetterInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleGetterInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.getter"), GradleDetector.GRADLE_GETTER);
    }
  }

  public static class AndroidLintGradleIdeErrorInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleIdeErrorInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.ide.error"), GradleDetector.IDE_SUPPORT);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull final String message) {
      // Quickfix for replacing packageName with applicationId.
      // This is a temporary quickfix to support older versions of the Gradle plugin: TODO REMOVE.
      if (message.contains("packageName")) {
        return new AndroidLintQuickFix[] { new AndroidLintQuickFix() {
          @Override
          public void apply(@NotNull PsiElement startElement,
                            @NotNull PsiElement endElement,
                            @NotNull AndroidQuickfixContexts.Context context) {
            if (context instanceof AndroidQuickfixContexts.EditorContext) {
              final Editor editor = ((AndroidQuickfixContexts.EditorContext)context).getEditor();
              if (startElement == endElement) {
                String text = startElement.getText();
                if (text.equals("packageName") || text.equals("packageNameSuffix")) {
                  int textOffset = startElement.getTextOffset();
                  editor.getDocument().replaceString(textOffset, textOffset + startElement.getTextLength(),
                                                     text.replace("packageName", "applicationId"));
                }
              }
            }
         }

          @Override
          public boolean isApplicable(@NotNull PsiElement startElement,
                                      @NotNull PsiElement endElement,
                                      @NotNull AndroidQuickfixContexts.ContextType contextType) {
            return true;
          }

          @NotNull
          @Override
          public String getName() {
            return message.replace("Deprecated: ", "");
          }
        }};
      }
      return super.getQuickFixes(message);
    }
  }

  public static class AndroidLintGradleOverridesInspection extends AndroidLintInspectionBase {
    public AndroidLintGradleOverridesInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.overrides"), ManifestDetector.GRADLE_OVERRIDES);
    }
  }

  public static class AndroidLintGradlePathInspection extends AndroidLintInspectionBase {
    public AndroidLintGradlePathInspection() {
      super(AndroidBundle.message("android.lint.inspections.gradle.path"), GradleDetector.PATH);
    }
  }

  public static class AndroidLintGrantAllUrisInspection extends AndroidLintInspectionBase {
    public AndroidLintGrantAllUrisInspection() {
      super(AndroidBundle.message("android.lint.inspections.grant.all.uris"), SecurityDetector.OPEN_PROVIDER);
    }
  }

  public static class AndroidLintWorldWriteableFilesInspection extends AndroidLintInspectionBase {
    public AndroidLintWorldWriteableFilesInspection() {
      super(AndroidBundle.message("android.lint.inspections.world.writeable.files"), SecurityDetector.WORLD_WRITEABLE);
    }
  }

  public static class AndroidLintStateListReachableInspection extends AndroidLintInspectionBase {
    public AndroidLintStateListReachableInspection() {
      super(AndroidBundle.message("android.lint.inspections.state.list.reachable"), StateListDetector.ISSUE);
    }
  }

  public static class AndroidLintTextFieldsInspection extends AndroidLintInspectionBase {
    public AndroidLintTextFieldsInspection() {
      super(AndroidBundle.message("android.lint.inspections.text.fields"), TextFieldDetector.ISSUE);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{
        new SetAttributeQuickFix(AndroidBundle.message("android.lint.fix.add.input.type.attribute"),
                                 SdkConstants.ATTR_INPUT_TYPE, null)
      };
    }
  }

  public static class AndroidLintTooManyViewsInspection extends AndroidLintInspectionBase {
    public AndroidLintTooManyViewsInspection() {
      super(AndroidBundle.message("android.lint.inspections.too.many.views"), TooManyViewsDetector.TOO_MANY);
    }
  }

  public static class AndroidLintTooDeepLayoutInspection extends AndroidLintInspectionBase {
    public AndroidLintTooDeepLayoutInspection() {
      super(AndroidBundle.message("android.lint.inspections.too.deep.layout"), TooManyViewsDetector.TOO_DEEP);
    }
  }

  public static class AndroidLintTypographyDashesInspection extends AndroidLintTypographyInspectionBase {
    public AndroidLintTypographyDashesInspection() {
      super(AndroidBundle.message("android.lint.inspections.typography.dashes"), TypographyDetector.DASHES);
    }
  }

  public static class AndroidLintTypographyQuotesInspection extends AndroidLintTypographyInspectionBase {
    public AndroidLintTypographyQuotesInspection() {
      super(AndroidBundle.message("android.lint.inspections.typography.quotes"), TypographyDetector.QUOTES);
    }
  }

  public static class AndroidLintTypographyFractionsInspection extends AndroidLintTypographyInspectionBase {
    public AndroidLintTypographyFractionsInspection() {
      super(AndroidBundle.message("android.lint.inspections.typography.fractions"), TypographyDetector.FRACTIONS);
    }
  }

  public static class AndroidLintTypographyEllipsisInspection extends AndroidLintTypographyInspectionBase {
    public AndroidLintTypographyEllipsisInspection() {
      super(AndroidBundle.message("android.lint.inspections.typography.ellipsis"), TypographyDetector.ELLIPSIS);
    }
  }

  public static class AndroidLintTypographyOtherInspection extends AndroidLintTypographyInspectionBase {
    public AndroidLintTypographyOtherInspection() {
      super(AndroidBundle.message("android.lint.inspections.typography.other"), TypographyDetector.OTHER);
    }
  }

  public static class AndroidLintUseCheckPermissionInspection extends AndroidLintInspectionBase {
    public AndroidLintUseCheckPermissionInspection() {
      super(AndroidBundle.message("android.lint.inspections.use.check.permission"), CheckPermissionDetector.ISSUE);
    }
  }

  public static class AndroidLintUseCompoundDrawablesInspection extends AndroidLintInspectionBase {
    public AndroidLintUseCompoundDrawablesInspection() {
      super(AndroidBundle.message("android.lint.inspections.use.compound.drawables"), UseCompoundDrawableDetector.ISSUE);
    }

    // todo: implement quickfix
  }

  public static class AndroidLintUselessParentInspection extends AndroidLintInspectionBase {
    public AndroidLintUselessParentInspection() {
      super(AndroidBundle.message("android.lint.inspections.useless.parent"), UselessViewDetector.USELESS_PARENT);
    }

    // todo: implement quickfix
  }

  public static class AndroidLintUselessLeafInspection extends AndroidLintInspectionBase {
    public AndroidLintUselessLeafInspection() {
      super(AndroidBundle.message("android.lint.inspections.useless.leaf"), UselessViewDetector.USELESS_LEAF);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[]{new RemoveUselessViewQuickFix(myIssue)};
    }
  }

  private abstract static class AndroidLintTypographyInspectionBase extends AndroidLintInspectionBase {
    public AndroidLintTypographyInspectionBase(String displayName, Issue issue) {
      super(displayName, issue);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[] {new TypographyQuickFix(myIssue, message)};
    }
  }

  public static class AndroidLintNewApiInspection extends AndroidLintInspectionBase {
    public AndroidLintNewApiInspection() {
      super(AndroidBundle.message("android.lint.inspections.new.api"), ApiDetector.UNSUPPORTED);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return getApiDetectorFixes(message);

    }
  }

  public static class AndroidLintInlinedApiInspection extends AndroidLintInspectionBase {
    public AndroidLintInlinedApiInspection() {
      super(AndroidBundle.message("android.lint.inspections.inlined.api"), ApiDetector.INLINED);
    }

    @NotNull
    @Override
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return getApiDetectorFixes(message);
    }
  }

  private static AndroidLintQuickFix[] getApiDetectorFixes(String message) {
    // TODO: Return one for each parent context (declaration, method, class, outer class(es)
    Pattern pattern = Pattern.compile("\\s(\\d+)\\s"); //$NON-NLS-1$
    Matcher matcher = pattern.matcher(message);
    if (matcher.find()) {
      int api = Integer.parseInt(matcher.group(1));
      return new AndroidLintQuickFix[] { new AddTargetApiQuickFix(api) };
    }
    return AndroidLintQuickFix.EMPTY_ARRAY;
  }

  public static class AndroidLintOverrideInspection extends AndroidLintInspectionBase {
    public AndroidLintOverrideInspection() {
      super(AndroidBundle.message("android.lint.inspections.override"), ApiDetector.OVERRIDE);
    }
  }

  public static class AndroidLintDuplicateUsesFeatureInspection extends AndroidLintInspectionBase {
    public AndroidLintDuplicateUsesFeatureInspection() {
      super(AndroidBundle.message("android.lint.inspections.duplicate.uses.feature"), ManifestDetector.DUPLICATE_USES_FEATURE);
    }
  }
  public static class AndroidLintMissingApplicationIconInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingApplicationIconInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.application.icon"), ManifestDetector.APPLICATION_ICON);
    }
  }
  public static class AndroidLintResourceCycleInspection extends AndroidLintInspectionBase {
    public AndroidLintResourceCycleInspection() {
      super(AndroidBundle.message("android.lint.inspections.resource.cycle"), ResourceCycleDetector.CYCLE);
    }
  }
  public static class AndroidLintResourceNameInspection extends AndroidLintInspectionBase {
    public AndroidLintResourceNameInspection() {
      super(AndroidBundle.message("android.lint.inspections.resource.name"), ResourcePrefixDetector.ISSUE);
    }
  }
  public static class AndroidLintRtlCompatInspection extends AndroidLintInspectionBase {
    public AndroidLintRtlCompatInspection() {
      super(AndroidBundle.message("android.lint.inspections.rtl.compat"), RtlDetector.COMPAT);
    }
  }
  public static class AndroidLintRtlEnabledInspection extends AndroidLintInspectionBase {
    public AndroidLintRtlEnabledInspection() {
      super(AndroidBundle.message("android.lint.inspections.rtl.enabled"), RtlDetector.ENABLED);
    }
  }
  public static class AndroidLintRtlHardcodedInspection extends AndroidLintInspectionBase {
    public AndroidLintRtlHardcodedInspection() {
      super(AndroidBundle.message("android.lint.inspections.rtl.hardcoded"), RtlDetector.USE_START);
    }
  }
  public static class AndroidLintRtlSymmetryInspection extends AndroidLintInspectionBase {
    public AndroidLintRtlSymmetryInspection() {
      super(AndroidBundle.message("android.lint.inspections.rtl.symmetry"), RtlDetector.SYMMETRY);
    }
  }

  // Missing the following issues, because they require classfile analysis:
  // FloatMath, FieldGetter, Override, OnClick, ViewTag, DefaultLocale, SimpleDateFormat,
  // Registered, MissingRegistered, Instantiatable, HandlerLeak, ValidFragment, SecureRandom,
  // ViewConstructor, Wakelock, Recycle, CommitTransaction, WrongCall, DalvikOverride

  // I think DefaultLocale is already handled by a regular IDEA code check.

  public static class AndroidLintAddJavascriptInterfaceInspection extends AndroidLintInspectionBase {
    public AndroidLintAddJavascriptInterfaceInspection() {
      super(AndroidBundle.message("android.lint.inspections.add.javascript.interface"), AddJavascriptInterfaceDetector.ISSUE);
    }
  }
  public static class AndroidLintAllowBackupInspection extends AndroidLintInspectionBase {
    public AndroidLintAllowBackupInspection() {
      super(AndroidBundle.message("android.lint.inspections.allow.backup"), ManifestDetector.ALLOW_BACKUP);
    }
  }
  public static class AndroidLintButtonStyleInspection extends AndroidLintInspectionBase {
    public AndroidLintButtonStyleInspection() {
      super(AndroidBundle.message("android.lint.inspections.button.style"), ButtonDetector.STYLE);
    }
  }

  public static class AndroidLintByteOrderMarkInspection extends AndroidLintInspectionBase {
    public AndroidLintByteOrderMarkInspection() {
      super(AndroidBundle.message("android.lint.inspections.byte.order.mark"), ByteOrderMarkDetector.BOM);
    }
  }

  public static class AndroidLintCommitPrefEditsInspection extends AndroidLintInspectionBase {
    public AndroidLintCommitPrefEditsInspection() {
      super(AndroidBundle.message("android.lint.inspections.commit.pref.edits"), SharedPrefsDetector.ISSUE);
    }
  }
  public static class AndroidLintCutPasteIdInspection extends AndroidLintInspectionBase {
    public AndroidLintCutPasteIdInspection() {
      super(AndroidBundle.message("android.lint.inspections.cut.paste.id"), CutPasteDetector.ISSUE);
    }
  }
  public static class AndroidLintDuplicateActivityInspection extends AndroidLintInspectionBase {
    public AndroidLintDuplicateActivityInspection() {
      super(AndroidBundle.message("android.lint.inspections.duplicate.activity"), ManifestDetector.DUPLICATE_ACTIVITY);
    }
  }
  public static class AndroidLintDuplicateDefinitionInspection extends AndroidLintInspectionBase {
    public AndroidLintDuplicateDefinitionInspection() {
      super(AndroidBundle.message("android.lint.inspections.duplicate.definition"), DuplicateResourceDetector.ISSUE);
    }
  }
  public static class AndroidLintEasterEggInspection extends AndroidLintInspectionBase {
    public AndroidLintEasterEggInspection() {
      super(AndroidBundle.message("android.lint.inspections.easter.egg"), CommentDetector.EASTER_EGG);
    }
  }
  public static class AndroidLintExportedContentProviderInspection extends AndroidLintInspectionBase {
    public AndroidLintExportedContentProviderInspection() {
      super(AndroidBundle.message("android.lint.inspections.exported.content.provider"), SecurityDetector.EXPORTED_PROVIDER);
    }
  }
  public static class AndroidLintExportedReceiverInspection extends AndroidLintInspectionBase {
    public AndroidLintExportedReceiverInspection() {
      super(AndroidBundle.message("android.lint.inspections.exported.receiver"), SecurityDetector.EXPORTED_RECEIVER);
    }
  }
  public static class AndroidLintIconColorsInspection extends AndroidLintInspectionBase {
    public AndroidLintIconColorsInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.colors"), IconDetector.ICON_COLORS);
    }
  }
  public static class AndroidLintIconExtensionInspection extends AndroidLintInspectionBase {
    public AndroidLintIconExtensionInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.extension"), IconDetector.ICON_EXTENSION);
    }
  }
  public static class AndroidLintIconLauncherShapeInspection extends AndroidLintInspectionBase {
    public AndroidLintIconLauncherShapeInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.launcher.shape"), IconDetector.ICON_LAUNCHER_SHAPE);
    }
  }
  public static class AndroidLintIconXmlAndPngInspection extends AndroidLintInspectionBase {
    public AndroidLintIconXmlAndPngInspection() {
      super(AndroidBundle.message("android.lint.inspections.icon.xml.and.png"), IconDetector.ICON_XML_AND_PNG);
    }
  }
  public static class AndroidLintIllegalResourceRefInspection extends AndroidLintInspectionBase {
    public AndroidLintIllegalResourceRefInspection() {
      super(AndroidBundle.message("android.lint.inspections.illegal.resource.ref"), ManifestDetector.ILLEGAL_REFERENCE);
    }
  }

  public static class AndroidLintImpliedQuantityInspection extends AndroidLintInspectionBase {
    public AndroidLintImpliedQuantityInspection() {
      super(AndroidBundle.message("android.lint.inspections.implied.quantity"), IMPLIED_QUANTITY);
    }
  }

  public static class AndroidLintIncludeLayoutParamInspection extends AndroidLintInspectionBase {
    public AndroidLintIncludeLayoutParamInspection() {
      super(AndroidBundle.message("android.lint.inspections.include.layout.param"), IncludeDetector.ISSUE);
    }
  }

  public static class AndroidLintInflateParamsInspection extends AndroidLintInspectionBase {
    public AndroidLintInflateParamsInspection() {
      super(AndroidBundle.message("android.lint.inspections.inflate.params"), LayoutInflationDetector.ISSUE);
    }
  }
  public static class AndroidLintInOrMmUsageInspection extends AndroidLintInspectionBase {
    public AndroidLintInOrMmUsageInspection() {
      super(AndroidBundle.message("android.lint.inspections.in.or.mm.usage"), PxUsageDetector.IN_MM_ISSUE);
    }
  }
  public static class AndroidLintInnerclassSeparatorInspection extends AndroidLintInspectionBase {
    public AndroidLintInnerclassSeparatorInspection() {
      super(AndroidBundle.message("android.lint.inspections.innerclass.separator"), MissingClassDetector.INNERCLASS);
    }
  }
  public static class AndroidLintInvalidIdInspection extends AndroidLintInspectionBase {
    public AndroidLintInvalidIdInspection() {
      super(AndroidBundle.message("android.lint.inspections.invalid.id"), WrongIdDetector.INVALID);
    }
  }
  public static class AndroidLintLabelForInspection extends AndroidLintInspectionBase {
    public AndroidLintLabelForInspection() {
      super(AndroidBundle.message("android.lint.inspections.label.for"), LabelForDetector.ISSUE);
    }
  }
  public static class AndroidLintLocaleFolderInspection extends AndroidLintInspectionBase {
    public AndroidLintLocaleFolderInspection() {
      super(AndroidBundle.message("android.lint.inspections.locale.folder"), com.android.tools.lint.checks.LocaleFolderDetector.ISSUE);
    }
  }
  public static class AndroidLintLocalSuppressInspection extends AndroidLintInspectionBase {
    public AndroidLintLocalSuppressInspection() {
      super(AndroidBundle.message("android.lint.inspections.local.suppress"), AnnotationDetector.ISSUE);
    }
  }
  // THIS ISSUE IS PROBABLY NOT NEEDED HERE!
  public static class AndroidLintMangledCRLFInspection extends AndroidLintInspectionBase {
    public AndroidLintMangledCRLFInspection() {
      super(AndroidBundle.message("android.lint.inspections.mangled.crlf"), DosLineEndingDetector.ISSUE);
    }
  }
  public static class AndroidLintMenuTitleInspection extends AndroidLintInspectionBase {
    public AndroidLintMenuTitleInspection() {
      super(AndroidBundle.message("android.lint.inspections.menu.title"), TitleDetector.ISSUE);
    }
  }
  public static class AndroidLintMissingIdInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingIdInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.id"), MissingIdDetector.ISSUE);
    }
  }
  public static class AndroidLintMissingVersionInspection extends AndroidLintInspectionBase {
    public AndroidLintMissingVersionInspection() {
      super(AndroidBundle.message("android.lint.inspections.missing.version"), ManifestDetector.SET_VERSION);
    }
  }
  public static class AndroidLintOldTargetApiInspection extends AndroidLintInspectionBase {
    public AndroidLintOldTargetApiInspection() {
      super(AndroidBundle.message("android.lint.inspections.old.target.api"), ManifestDetector.TARGET_NEWER);
    }
  }
  public static class AndroidLintOrientationInspection extends AndroidLintInspectionBase {
    public AndroidLintOrientationInspection() {
      super(AndroidBundle.message("android.lint.inspections.orientation"), InefficientWeightDetector.ORIENTATION);
    }
  }
  public static class AndroidLintPackagedPrivateKeyInspection extends AndroidLintInspectionBase {
    public AndroidLintPackagedPrivateKeyInspection() {
      super(AndroidBundle.message("android.lint.inspections.packaged.private.key"), PrivateKeyDetector.ISSUE);
    }
  }
  public static class AndroidLintPropertyEscapeInspection extends AndroidLintInspectionBase {
    public AndroidLintPropertyEscapeInspection() {
      super(AndroidBundle.message("android.lint.inspections.property.escape"), PropertyFileDetector.ISSUE);
    }
  }
  public static class AndroidLintProtectedPermissionsInspection extends AndroidLintInspectionBase {
    public AndroidLintProtectedPermissionsInspection() {
      super(AndroidBundle.message("android.lint.inspections.protected.permissions"), SystemPermissionsDetector.ISSUE);
    }
  }
  public static class AndroidLintReferenceTypeInspection extends AndroidLintInspectionBase {
    public AndroidLintReferenceTypeInspection() {
      super(AndroidBundle.message("android.lint.inspections.reference.type"), DuplicateResourceDetector.TYPE_MISMATCH);
    }
  }
  public static class AndroidLintRegisteredInspection extends AndroidLintInspectionBase {
    public AndroidLintRegisteredInspection() {
      super(AndroidBundle.message("android.lint.inspections.registered"), RegistrationDetector.ISSUE);
    }
  }
  public static class AndroidLintRequiredSizeInspection extends AndroidLintInspectionBase {
    public AndroidLintRequiredSizeInspection() {
      super(AndroidBundle.message("android.lint.inspections.required.size"), RequiredAttributeDetector.ISSUE);
    }
  }
  public static class AndroidLintResAutoInspection extends AndroidLintInspectionBase {
    public AndroidLintResAutoInspection() {
      super(AndroidBundle.message("android.lint.inspections.res.auto"), NamespaceDetector.RES_AUTO);
    }

    @Override
    @NotNull
    public AndroidLintQuickFix[] getQuickFixes(@NotNull String message) {
      return new AndroidLintQuickFix[] { new ConvertNamespaceQuickFix() };
    }
  }
  public static class AndroidLintSelectableTextInspection extends AndroidLintInspectionBase {
    public AndroidLintSelectableTextInspection() {
      super(AndroidBundle.message("android.lint.inspections.selectable.text"), TextViewDetector.SELECTABLE);
    }
  }
  public static class AndroidLintServiceCastInspection extends AndroidLintInspectionBase {
    public AndroidLintServiceCastInspection() {
      super(AndroidBundle.message("android.lint.inspections.service.cast"), ServiceCastDetector.ISSUE);
    }
  }
  public static class AndroidLintSetJavaScriptEnabledInspection extends AndroidLintInspectionBase {
    public AndroidLintSetJavaScriptEnabledInspection() {
      super(AndroidBundle.message("android.lint.inspections.set.java.script.enabled"), SetJavaScriptEnabledDetector.ISSUE);
    }
  }
  public static class AndroidLintShowToastInspection extends AndroidLintInspectionBase {
    public AndroidLintShowToastInspection() {
      super(AndroidBundle.message("android.lint.inspections.show.toast"), ToastDetector.ISSUE);
    }
  }
  public static class AndroidLintSignatureOrSystemPermissionsInspection extends AndroidLintInspectionBase {
    public AndroidLintSignatureOrSystemPermissionsInspection() {
      super(AndroidBundle.message("android.lint.inspections.signature.or.system.permissions"), SignatureOrSystemDetector.ISSUE);
    }
  }
  public static class AndroidLintSmallSpInspection extends AndroidLintInspectionBase {
    public AndroidLintSmallSpInspection() {
      super(AndroidBundle.message("android.lint.inspections.small.sp"), PxUsageDetector.SMALL_SP_ISSUE);
    }
  }
  public static class AndroidLintSpUsageInspection extends AndroidLintInspectionBase {
    public AndroidLintSpUsageInspection() {
      super(AndroidBundle.message("android.lint.inspections.sp.usage"), PxUsageDetector.DP_ISSUE);
    }
  }
  // Maybe not relevant
  public static class AndroidLintStopShipInspection extends AndroidLintInspectionBase {
    public AndroidLintStopShipInspection() {
      super(AndroidBundle.message("android.lint.inspections.stop.ship"), CommentDetector.STOP_SHIP);
    }
  }
  public static class AndroidLintSuspicious0dpInspection extends AndroidLintInspectionBase {
    public AndroidLintSuspicious0dpInspection() {
      super(AndroidBundle.message("android.lint.inspections.suspicious0dp"), InefficientWeightDetector.WRONG_0DP);
    }
  }
  public static class AndroidLintTyposInspection extends AndroidLintInspectionBase {
    public AndroidLintTyposInspection() {
      super(AndroidBundle.message("android.lint.inspections.typos"), TypoDetector.ISSUE);
    }
  }
  public static class AndroidLintUniquePermissionInspection extends AndroidLintInspectionBase {
    public AndroidLintUniquePermissionInspection() {
      super(AndroidBundle.message("android.lint.inspections.unique.permission"), ManifestDetector.UNIQUE_PERMISSION);
    }
  }
  public static class AndroidLintUnlocalizedSmsInspection extends AndroidLintInspectionBase {
    public AndroidLintUnlocalizedSmsInspection() {
      super(AndroidBundle.message("android.lint.inspections.unlocalized.sms"), NonInternationalizedSmsDetector.ISSUE);
    }
  }
  public static class AndroidLintWorldReadableFilesInspection extends AndroidLintInspectionBase {
    public AndroidLintWorldReadableFilesInspection() {
      super(AndroidBundle.message("android.lint.inspections.world.readable.files"), SecurityDetector.WORLD_READABLE);
    }
  }
  public static class AndroidLintWrongCallInspection extends AndroidLintInspectionBase {
    public AndroidLintWrongCallInspection() {
      super(AndroidBundle.message("android.lint.inspections.wrong.call"), WrongCallDetector.ISSUE);
    }
  }
  public static class AndroidLintWrongCaseInspection extends AndroidLintInspectionBase {
    public AndroidLintWrongCaseInspection() {
      super(AndroidBundle.message("android.lint.inspections.wrong.case"), WrongCaseDetector.WRONG_CASE);
    }
  }
  public static class AndroidLintWrongFolderInspection extends AndroidLintInspectionBase {
    public AndroidLintWrongFolderInspection() {
      super(AndroidBundle.message("android.lint.inspections.wrong.folder"), WrongLocationDetector.ISSUE);
    }
  }
}

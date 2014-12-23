package de.steinberg.gyp.gui.view.tree.filesystem;

import de.steinberg.gyp.core.filesystem.FileSet;
import de.steinberg.gyp.core.filesystem.FileSetComparator;
import de.steinberg.gyp.core.filesystem.FileSetComparisonResult;
import de.steinberg.gyp.core.filesystem.FileSystemAccessor;
import de.steinberg.gyp.gui.view.result.ComparisonResultView;
import lombok.Data;
import lombok.Setter;

import javax.inject.Inject;
import java.util.concurrent.Callable;

/**
 * Created by LKLeen on 19.12.2014.
 */
public class PathTreeViewComparator implements Callable<PathTreeViewComparator.Result> {

    @Data
    public class Result {
        final FileSet filesMissingInFilesystem;
        final FileSet filesMissingInConfiguration;

        public Result(FileSet filesMissingInFilesystem, FileSet filesMissingInConfiguration) {
            this.filesMissingInFilesystem = filesMissingInFilesystem;
            this.filesMissingInConfiguration = filesMissingInConfiguration;
        }
    }

    @Inject
    FileSystemAccessor fileSystemAccessor;

    @Inject
    FileSetComparator fileSetComparator;

    @Inject
    ComparisonResultView resultView;

    @Setter
    PathComparisonParameters parameters;

    @Override
    public Result call() throws Exception {
        FileSet filesInFileSystem = fileSystemAccessor.getFilesFrom(parameters.getPath());
        FileSet filesInGypNode = parameters.getGypNode().getAllFiles();
        FileSetComparisonResult filesetResult = fileSetComparator.compare(filesInFileSystem, filesInGypNode);
        Result result = new Result(filesetResult.missingLeft, filesetResult.missingRight);
        resultView.print(result);
        return result;
    }

}
